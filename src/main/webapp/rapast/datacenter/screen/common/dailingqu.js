(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('带岭区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230713","properties":{"name":"带岭区","cp":[129.021151,47.027532],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@iBODMHKRSÞÙLMHO@O@UBKDGHKPQVOHIDM@KCIMQAOBMHMPIRCXBR@HEDIBKGIGECE@IFKJETG\\GlEbC`@VBLAHCHIVeZkRcLcPmV_VedkPSBI@KGISUOWGQGYGDMHKFO@QBWBELGFORKDC@KA}aMCS@IBQFSJEJELIDSJUDGDIHGLKTaATCPIT@BC@A@ABA@A@AB@@@@@@A@A@A@@@@@ABC@CB@BA@@BAB@B@@@@@BA@@@ABA@A@@@ABA@AB@@ADABAB@@A@@B@@A@AB@B@@AB@@ABA@AB@@@@@BBDB@@B@BBB@@@@@BBB@@@D@@B@@@H@BBDB@F@B@@@B@@@B@AC@CAABB@DBBBBBBBFB@@B@B@HBJDHBF@@@@B@@A@A@AB@@@@@B@@@BABAB@BAB@@AB@BA@AB@DA@@D@B@BA@@FGPONYL]LeTkX«fUFQDKCKAUGK@UBG@EA]cCAK@CBWTCFKPIDQDUFMBKAGGQKICQAMJMLOLMRKRKVANAP@NH^DFNLPNDR@LCNGLBNFRfzBF@LARDLJRNHTDVDJF@DVPVLVJZFbHZH`NZF`PlXXHRF"],"encodeOffsets":[[131968,48510]]}}],"UTF8Encoding":true});}));