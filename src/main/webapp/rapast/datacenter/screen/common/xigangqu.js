(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('西岗区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"210203","properties":{"name":"西岗区","cp":[121.616112,38.914266],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@F@@AB@B@@@B@B@@A@@@@@A@@B@@@@@@@@@@@@@@@@@@B@@B@@@@@@@B@@@@A@@@@@@@@@@@@@@@@@@B@@@@@@@@@@B@@@@@@@@@@@@@@BB@@@@@@@A@@@@B@@@@@@@@@@@@@@@@@@@@B@@@@@@@@@@BB@@@@@@@@@@@@@@@@@@@@@@B@@@@@@@@@@@@@@@B@@@@@@A@@@@@@A@@@@@@A@@@@@@B@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B@@@@@@@@@@B@@@@@@@@@@@@@@B@@@@B@@@@@@@@@@@@@@B@@@@@@@@B@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B@@@@@@@@@@@@@@@@B@@@@@@@@@@@@@B@@@@@@@B@@@@@B@@@@@@@@@@@@@@@A@@A@@@@@@@@B@@@@@@@@@@@@@@@B@@@BB@@@@@@@B@@@@ABCDA@A@@@@@@@@@@@AB@@A@@@@@@@A@AB@@AD@@@@B@DB@@@@AB@@AB@@@@@@AB@BAB@@@@@B@@@@A@@@@@@@FBDB@@@@@@@@@@B@DD@@@@@@@@@B@BAF@B@@@@@@@@@B@@@@@B@@@@@@@@@B@@@FGA@@@@@B@B@@@@@@@B@@@@@@A@ABA@AB@@C@C@@@@@A@A@IB@B@@@@@@B@@@@@@B@@@@@BBB@@@@@@@@@B@@@@@B@@A@@BHF@BB@AB@B@@DF@@@B@B@BBD@@@B@@@@D@B@BAB@B@@@B@DBRBL@@A@ABCBGBEBAB@BAF@pTF@D@D@M[CAAAICA@AAAAEACCCAAACAA@AAA@A@BA@@@@@@ACF@DA@@AA@AA@@A@@@@@@@@HC@C@A@@@@@A@@AA@@@@@@@@@A@@@@@@@@A@@AA@@@@@@AB@@@@AB@BA@@BA@EB@@@DAB@BCDCBA@A@@@@@AB@FAD@B@@@@@@@@@@A@@@@@@@@B@@@@@@@@A@@@A@@@A@@@@@@@A@@AC@A@@@@@A@@@@A@@@A@@@A@C@A@@@AAA@A@@@A@@@@@A@@A@@A@CB@A@@ACAC@@@@@@@@@@@@@@AA@@AA@@@@@AA@@@@@CC@@ACA@@A@A@E@@AB@@@@A@@@@@C@@@A@A@@@AAA@A@@@@@A@@BA@A@@BAB@BA@A@@@A@@B@@AB@BA@GDA@"],"encodeOffsets":[[124523,39805]]}}],"UTF8Encoding":true});}));