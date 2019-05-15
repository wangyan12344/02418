(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('文圣区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"211003","properties":{"name":"文圣区","cp":[123.188227,41.266765],"childNum":2},"geometry":{"type":"MultiPolygon","coordinates":[["@@AA@A@ABABMDCGIAA@@A@AEACCAAACAAACGAAA@AA@@ACECGECAICCBCB@@@BAFCHABCBE@EBIAM@KBGBABGCCC@@@B@@ABA@@@@@@B@@AHA@AF@DH@DDBD@D@BBBBBABABIFAB@@ND@@B@BA@ADCDABADBD@FBF@@B@@@@@B@@@B@@@BDBB@BBAB@BB@@@B@BAB@D@B@@@ADCBA@@BA@BB@AB@B@@@@@B@@ABBB@@@@@B@@@@B@@G@A@ABA@ABB@AB@@@FAAA@@@A@@@@@EA@F@D@@I@A@@@@@@AAACB@A@A@@@@JC@@@@F@@CB@@AA@GA@@@@@B@@@B@@@B@@@@C@@@ADE@A@@A@@@AB@@@EA@@C@@@@@@BEA@DA@@A@@@A@AOAA@@B@BD@DB@@@@C@@@@@@B@B@BB@@@@@@@@@@@@@@BB@@@ABBBB@B@@BD@B@@B@@A@@B@@@@@BFB@A@BB@DA@D@BB@ABBB@B@@A@BB@@B@@@B@B@B@@@@@@A@@B@@B@@@@DB@@@@D@@A@@@@@A@@@@@@AA@@@@@AAA@AAA@AC@@@BEB@@A@@@BF@@@@@RA@@@@@@BB@@@BF@@BDDB@DDBBDDB@@@B@DBFAB@B@B@BBD@LKBK@AECAAAA@A@AE@BC@AC@ECBE@@BAB@D@B@B@BBD@BBD@D@B@D@B@@@DAD@BBB@DBD@DBBBDA"],["@@@B@@ABBD@@G@@@@@G@@@@@K@@@@@C@@F@@@BOA@@I@@@@@A@@@@@@@@@@@E@@@@@C@@DBD@@@@@D@@@@BD@@@@@B@@@@BD@B@@@@@@@B@@@B@BBB@B@@@B@@BF@B@B@@@@@@BD@@@@D@B@@@@@@@B@B@@@@@B@@@@@@DBD@@@@BF@@@@@B@@B@@@DB@@@@@@@@BFJ@H@BF@@DDBB@@B@LL@B@@@@D@BA@A@ABA@@@CAA@@BAFEBABAB@AA@@AC@@@@CE@@@@AA@@@@AA@@@@AACA@AA@@@@@CGEE@EBCDEHEJCJGVMGAED@@C@@@BAA@ABAG@@A@AACF@BAADC@AAAABAAA@AAAB@DA@CBA@@BAA@@A@@@"]],"encodeOffsets":[[[126295,42273]],[[126168,42237]]]}}],"UTF8Encoding":true});}));