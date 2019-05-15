package com.repast.core.spring.mvc.method.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;
import org.springframework.web.util.WebUtils;

import com.repast.core.spring.mvc.bind.annotation.FormModel;
import com.repast.core.spring.mvc.util.MapWapper;
import com.repast.core.tool.SmartDateFormat;
/**
 * 处理表单类型的数据到对象的绑定
 * @author luandong
 *
 */
public class FormModelMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public FormModelMethodArgumentResolver() {
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(FormModel.class)) {
            return true;
        }
        return false;
    }

    /**
     * Resolve the argument from the model or if not found instantiate it with 
     * its default if it is available. The model attribute is then populated 
     * with request values via data binding and optionally validated
     * if {@code @java.validation.Valid} is present on the argument.
     * @throws BindException if data binding and validation result in an error
     * and the next method parameter is not of type {@link Errors}.
     * @throws Exception if WebDataBinder initialization fails.
     */
    public final Object resolveArgument(MethodParameter parameter,
                                        ModelAndViewContainer mavContainer,
                                        NativeWebRequest request,
                                        WebDataBinderFactory binderFactory) throws Exception {
        
    	//luandong:增加@formModel的value值没设置时，以后面的变量名为准
    	//String name = parameter.getParameterAnnotation(FormModel.class).value();
        
    	FormModel formObj = parameter.getParameterAnnotation(FormModel.class);
    	String name = getAlias(formObj,parameter);
        
        Object target = (mavContainer.containsAttribute(name)) ?
                mavContainer.getModel().get(name) : createAttribute(name, parameter, binderFactory, request);
        
        WebDataBinder binder = binderFactory.createBinder(request, target, name);
        //luandong：2015-03-02,增加日期类型的处理方法 begin
        SmartDateFormat smartDF = new SmartDateFormat();
        CustomDateEditor dateEditor = new CustomDateEditor(smartDF,true);
        binder.registerCustomEditor(Date.class,dateEditor);
        //end
        
        target = binder.getTarget();
        if (target != null) {
            bindRequestParameters(mavContainer, binderFactory, binder, request, parameter);
            
            validateIfApplicable(binder, parameter);
            if (binder.getBindingResult().hasErrors()) {
                if (isBindExceptionRequired(binder, parameter)) {
                    throw new BindException(binder.getBindingResult());
                }
            }
        }
        
        target = binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType());
        mavContainer.addAttribute(name, target);
        
        return target;
    }

    
    private String getAlias(FormModel formObj, MethodParameter parameter) {
        //得到FormObj的属性value，也就是对象参数的简称
        String alias = formObj.value();
        if(alias == null || "".equals(alias)) {
            //如果简称为空，取对象简称的首字母小写开头
            String simpleName = parameter.getParameterType().getSimpleName();
            alias = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
        }
        return alias;
    }

    /**
     * Extension point to create the model attribute if not found in the model.
     * The default implementation uses the default constructor.
     * @param attributeName the name of the attribute, never {@code null}
     * @param parameter the method parameter
     * @param binderFactory for creating WebDataBinder instance
     * @param request the current request
     * @return the created model attribute, never {@code null}
     */
    protected Object createAttribute(String attributeName, MethodParameter parameter,
            WebDataBinderFactory binderFactory,  NativeWebRequest request) throws Exception {

        String value = getRequestValueForAttribute(attributeName, request);
        
        if (value != null) {
            Object attribute = createAttributeFromRequestValue(value, attributeName, parameter, binderFactory, request);
            if (attribute != null) {
                return attribute;
            }
        }
        Class<?> parameterType = parameter.getParameterType();
        if(parameterType.isArray() || List.class.isAssignableFrom(parameterType)) {
            return ArrayList.class.newInstance();
        }
        if(Set.class.isAssignableFrom(parameterType)) {
            return HashSet.class.newInstance();
        }
        
        if(MapWapper.class.isAssignableFrom(parameterType)) {
            return MapWapper.class.newInstance();
        }
        
        return BeanUtils.instantiateClass(parameter.getParameterType());
    }
    
    
    /**
     * Obtain a value from the request that may be used to instantiate the
     * model attribute through type conversion from String to the target type. 
     * <p>The default implementation looks for the attribute name to match
     * a URI variable first and then a request parameter.
     * @param attributeName the model attribute name
     * @param request the current request
     * @return the request value to try to convert or {@code null}
     */
    protected String getRequestValueForAttribute(String attributeName, NativeWebRequest request) {
        Map<String, String> variables = getUriTemplateVariables(request);
        if (StringUtils.hasText(variables.get(attributeName))) {
            return variables.get(attributeName);
        }
        else if (StringUtils.hasText(request.getParameter(attributeName))) {
            return request.getParameter(attributeName);
        }
        else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    protected final Map<String, String> getUriTemplateVariables(NativeWebRequest request) {
        Map<String, String> variables = 
            (Map<String, String>) request.getAttribute(
                    HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        return (variables != null) ? variables : Collections.<String, String>emptyMap();
    }

    /**
     * Create a model attribute from a String request value (e.g. URI template
     * variable, request parameter) using type conversion.
     * <p>The default implementation converts only if there a registered 
     * {@link Converter} that can perform the conversion.
     * @param sourceValue the source value to create the model attribute from
     * @param attributeName the name of the attribute, never {@code null}
     * @param parameter the method parameter
     * @param binderFactory for creating WebDataBinder instance
     * @param request the current request
     * @return the created model attribute, or {@code null}
     * @throws Exception
     */
    protected Object createAttributeFromRequestValue(String sourceValue,
                                                 String attributeName, 
                                                 MethodParameter parameter, 
                                                 WebDataBinderFactory binderFactory, 
                                                 NativeWebRequest request) throws Exception {
        DataBinder binder = binderFactory.createBinder(request, null, attributeName);
        ConversionService conversionService = binder.getConversionService();
        if (conversionService != null) {
            TypeDescriptor source = TypeDescriptor.valueOf(String.class);
            TypeDescriptor target = new TypeDescriptor(parameter);
            if (conversionService.canConvert(source, target)) {
                return binder.convertIfNecessary(sourceValue, parameter.getParameterType(), parameter);
            }
        }
        return null;
    }
    
    /**
     * {@inheritDoc}
     * <p>Downcast {@link WebDataBinder} to {@link ServletRequestDataBinder} before binding.
     * @throws Exception 
     * @see ServletRequestDataBinderFactory
     */
    protected void bindRequestParameters(
            ModelAndViewContainer mavContainer,
            WebDataBinderFactory binderFactory,
            WebDataBinder binder, 
            NativeWebRequest request, 
            MethodParameter parameter) throws Exception {
        
        
        Class<?> targetType = binder.getTarget().getClass();
        ServletRequest servletRequest = prepareServletRequest(binder.getTarget(), request, parameter);
        WebDataBinder simpleBinder = binderFactory.createBinder(request, null, null);
        
        if(Collection.class.isAssignableFrom(targetType)) {//bind collection
            
            Type type = parameter.getGenericParameterType();
            Class<?> componentType = Object.class;
            
            Collection target = (Collection) binder.getTarget();

            if(type instanceof ParameterizedType) {
                componentType = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
            }
            
            if(parameter.getParameterType().isArray()) {
                componentType = parameter.getParameterType().getComponentType();
            }
            
            //luandong:增加list类型时，已经转换值后的记录
            Map isBindedKey = new HashMap();
            Set keySets = servletRequest.getParameterMap().keySet();
            Object[] keyArray = new Object[keySets.size()];
            keyArray = keySets.toArray(new Object[]{});
            
            for(Object key : keyArray) {
            	
      
            	
                String prefixName = getPrefixName((String) key);
                
              	if(isBindedKey.containsKey(prefixName)){
            		continue;
            	}else{
            		isBindedKey.put(prefixName,prefixName);
            	}
              	
                if(isSimpleComponent(prefixName)) { //bind simple type 
                	
                	//2015-3-5luandong:增加循环时的dyupdate处理，此处没考虑好，后续可以放在list中item的对象中
                	if(prefixName.equals(""))
                		continue;
                    Map<String, Object> paramValues = WebUtils.getParametersStartingWith(servletRequest, prefixName);
                    for(Object value : paramValues.values()) {
                        target.add(simpleBinder.convertIfNecessary(value, componentType));
                    }
                } else {
                    
                    Object component = BeanUtils.instantiate(componentType);
                    WebDataBinder componentBinder = binderFactory.createBinder(request, component, null);
                    //luandong add
                    SmartDateFormat smartDF = new SmartDateFormat();
                    CustomDateEditor dateEditor = new CustomDateEditor(smartDF,true);
                    componentBinder.registerCustomEditor(Date.class,dateEditor);
                    
                    component = componentBinder.getTarget();
                    
                    if (component != null) {
                    	
                    	Pattern p_html = Pattern.compile("\\[\\d\\].", Pattern.CASE_INSENSITIVE);  
                    	MockHttpServletRequest mr =(MockHttpServletRequest)servletRequest;
                    	String[] dyFileds = mr.getParameterValues("dynamic_update_fileld");
                    	Map newDyFiledsList = new HashMap();
                    			
                    	for(String itField:dyFileds){
                    		Matcher m_html = p_html.matcher(itField);  
                    		String htmlStr = m_html.replaceAll("");
                    		newDyFiledsList.put(htmlStr, htmlStr);
                    	}
                    	
                    
                    	mr.setParameter(prefixName+"dynamic_update_fileld",(String[]) newDyFiledsList.keySet().toArray(new String[]{}));
                    	
                        ServletRequestParameterPropertyValues pvs = new ServletRequestParameterPropertyValues(servletRequest, prefixName, "");
                        
                        componentBinder.bind(pvs);
                        validateIfApplicable(componentBinder, parameter);
                        if (componentBinder.getBindingResult().hasErrors()) {
                            if (isBindExceptionRequired(componentBinder, parameter)) {
                                throw new BindException(componentBinder.getBindingResult());
                            }
                        }
                        
                        target.add(component);
                    }
                }
            }
        } else if(MapWapper.class.isAssignableFrom(targetType)) { 
            
            
            Type type = parameter.getGenericParameterType();
            Class<?> keyType = Object.class;
            Class<?> valueType = Object.class;

            if(type instanceof ParameterizedType) {
                keyType = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
                valueType = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[1];
            }
            
            
            Map target = new HashMap();
            ((MapWapper)binder.getTarget()).setInnerMap(target);
            
            for(Object key : servletRequest.getParameterMap().keySet()) {
                String prefixName = getPrefixName((String) key);
                
                Object keyValue = simpleBinder.convertIfNecessary(getMapKey(prefixName), keyType);
                
                if(isSimpleComponent(prefixName)) { //bind simple type 
                    Map<String, Object> paramValues = WebUtils.getParametersStartingWith(servletRequest, prefixName);
                    
                    for(Object value : paramValues.values()) {
                        target.put(keyValue, simpleBinder.convertIfNecessary(value, valueType));
                    }
                } else {
                    Object component = BeanUtils.instantiate(valueType);
                    WebDataBinder componentBinder = binderFactory.createBinder(request, component, null);
                    component = componentBinder.getTarget();
                    
                    if (component != null) {
                    	
                    	
                        ServletRequestParameterPropertyValues pvs = new ServletRequestParameterPropertyValues(servletRequest, prefixName, "");
                        componentBinder.bind(pvs);
                        
                        validateComponent(componentBinder, parameter);
                        
                        target.put(keyValue, component);
                    }
                }
            }
        } else {//bind model
            ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder;
            servletBinder.bind(servletRequest);
        }
    }


    private Object getMapKey(String prefixName) {
        String key = prefixName;
        if(key.startsWith("['")) {
            key = key.replaceAll("\\[\'", "").replaceAll("\'\\]", "");
        }
        if(key.startsWith("[\"")) {
            key = key.replaceAll("\\[\"", "").replaceAll("\"\\]", "");
        }
        if(key.endsWith(".")) {
            key = key.substring(0, key.length() - 1);
        }
        return key;
    }

    private boolean isSimpleComponent(String prefixName) {
        return !prefixName.endsWith(".");
    }

    private String getPrefixName(String name) {
        
        int begin = 0;
        
        int end = name.indexOf("]") + 1;
        
        if(name.indexOf("].") >= 0) {
            end = end + 1;
        }
        
        return name.substring(begin, end);
    }

    private ServletRequest prepareServletRequest(Object target, NativeWebRequest request, MethodParameter parameter) {
        
       // String modelPrefixName = parameter.getParameterAnnotation(FormModel.class).value();
        
        FormModel formObj = parameter.getParameterAnnotation(FormModel.class);
    	String modelPrefixName = getAlias(formObj,parameter);
        
        HttpServletRequest nativeRequest = (HttpServletRequest) request.getNativeRequest();
        MultipartRequest multipartRequest = WebUtils.getNativeRequest(nativeRequest, MultipartRequest.class);
        
        MockHttpServletRequest mockRequest = null;
        if(multipartRequest != null) {
            MockMultipartHttpServletRequest mockMultipartRequest = new MockMultipartHttpServletRequest();
            mockMultipartRequest.getMultiFileMap().putAll(multipartRequest.getMultiFileMap());
        } else {
            mockRequest = new MockHttpServletRequest();
        }
        for(Entry<String, String> entry : getUriTemplateVariables(request).entrySet()) {
            String parameterName = entry.getKey();
            String value = entry.getValue();
            if(isFormModelAttribute(parameterName, modelPrefixName)) {
                mockRequest.setParameter(getNewParameterName(parameterName, modelPrefixName), value);
            }
        }
        
        //luandong2015-2-27，增加Model对象dynamic-update处理，此处记录本次提交数据中，包含的属性
        List<String> dyUpdate = new ArrayList<String>();
        
        for(Object parameterEntry : nativeRequest.getParameterMap().entrySet()) {
            Entry<String, String[]> entry = (Entry<String, String[]>) parameterEntry;
            String parameterName = entry.getKey();
            String[] value = entry.getValue();
            if(isFormModelAttribute(parameterName, modelPrefixName)) {
            	String newParamName = getNewParameterName(parameterName, modelPrefixName);
                mockRequest.setParameter(newParamName, value);
                dyUpdate.add(newParamName);
            }
        }
        if(dyUpdate!=null&&dyUpdate.size()>0)
        	 mockRequest.setParameter("dynamic_update_fileld", dyUpdate.toArray(new String[]{}));
        
        return mockRequest;
    }

    private String getNewParameterName(String parameterName, String modelPrefixName) {
        int modelPrefixNameLength = modelPrefixName.length();
        
        if(parameterName.charAt(modelPrefixNameLength) == '.') {
            return parameterName.substring(modelPrefixNameLength + 1);
        }
        
        if(parameterName.charAt(modelPrefixNameLength) == '[') {
            return parameterName.substring(modelPrefixNameLength);
        }
        throw new IllegalArgumentException("illegal request parameter, can not binding to @FormBean("+modelPrefixName+")");
    }

    private boolean isFormModelAttribute(String parameterName, String modelPrefixName) {
        int modelPrefixNameLength = modelPrefixName.length();
        
        if(parameterName.length() == modelPrefixNameLength) {
            return false;
        }
        
        if(!parameterName.startsWith(modelPrefixName)) {
            return false;
        }
        
        
        char ch = (char) parameterName.charAt(modelPrefixNameLength);
       
        if(ch == '.' || ch == '[') {
            return true;
        }
        
        return false;
    }

    protected void validateComponent(WebDataBinder binder, MethodParameter parameter) throws BindException {
        
        boolean validateParameter = validateParameter(parameter);
        Annotation[] annotations = binder.getTarget().getClass().getAnnotations();
        for (Annotation annot : annotations) {
            if (annot.annotationType().getSimpleName().startsWith("Valid") && validateParameter) {
                Object hints = AnnotationUtils.getValue(annot);
                binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
            }
        }

        if (binder.getBindingResult().hasErrors()) {
            if (isBindExceptionRequired(binder, parameter)) {
                throw new BindException(binder.getBindingResult());
            }
        }
    }

    private boolean validateParameter(MethodParameter parameter) {
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annot : annotations) {
            if (annot.annotationType().getSimpleName().startsWith("Valid")) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Validate the model attribute if applicable.
     * <p>The default implementation checks for {@code @javax.validation.Valid}.
     * @param binder the DataBinder to be used
     * @param parameter the method parameter
     */
    protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
        Annotation[] annotations = parameter.getParameterAnnotations();
        for (Annotation annot : annotations) {
            if (annot.annotationType().getSimpleName().startsWith("Valid")) {
                Object hints = AnnotationUtils.getValue(annot);
                binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
            }
        }
    }

    /**
     * Whether to raise a {@link BindException} on bind or validation errors.
     * The default implementation returns {@code true} if the next method 
     * argument is not of type {@link Errors}.
     * @param binder the data binder used to perform data binding
     * @param parameter the method argument
     */
    protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter parameter) {
        int i = parameter.getParameterIndex();
        Class<?>[] paramTypes = parameter.getMethod().getParameterTypes();
        boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
        
        return !hasBindingResult;
    }
}
