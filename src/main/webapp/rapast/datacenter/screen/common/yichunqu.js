(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('伊春区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230702","properties":{"name":"伊春区","cp":[128.899284,47.726851],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@FIPKXS\\[XUV]H[AQKKUKYSUKUK_KOCK@IDKJSVUhEbB`H`JVJPLPJLLFVBN@HD"],"encodeOffsets":[[131978,48941]]}}],"UTF8Encoding":true});}));