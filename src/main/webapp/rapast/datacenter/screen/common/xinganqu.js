(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('兴安区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230405","properties":{"name":"兴安区","cp":[130.236169,47.252911],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@I@A@ECAACAAAG@EG@AAA@AAEACBA@ABAB@DAFAB@@@ECCA@@@AAABE@@BGDCHO@EBA@@@E@C@A@G@GBC@A@C@C@@@C@CUCIBM@A@@AAD@BAD@B@DAB@BAF@DAB@BAFAB@B@@CFAFCJADADAD@@E@OBO@IAA@EN@BA@F@JBNEX@ABADAHAFA@@BB@@BBDDHDJ@@DDA@CDA@A@IB@DBBDDADCJF@@@@B@@C@C@EHOVPD@@@@@@DEFBDBBA@ADCFAF@RAD@@@DAB@@BB@@@B@BADAB@@@DABAB@D@BABALADAB@B@JFF_"],"encodeOffsets":[[133412,48377]]}}],"UTF8Encoding":true});}));