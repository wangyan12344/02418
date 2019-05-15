(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('梨树区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230305","properties":{"name":"梨树区","cp":[130.697781,45.092195],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@AAAA@AA@@@A@@@A@@@A@@@A@@@A@A@@@@BBB@@BB@D@B@BAB@@@@@BB@@BBB@B@B@D@BBBA@@B@B@@ABA@A@ABA@@@A@A@@BA@@BAD@@AB@@@B@D@B@DA@@B@B@B@BAB@B@B@DA@@D@BAB@BA@@@@B@@A@@@@@@BB@A@@B@B@DAFA@@B@@@B@DBD@BBB@@B@@@B@B@@AB@F@B@D@D@@B@@BBB@B@BAB@@BD@BBBB@BBB@DB@@D@@@BAB@DAB@B@B@B@B@B@D@B@B@@AB@B@B@BAB@@@B@@@B@@@F@B@@@@A@A@AAA@AAC@C@A@C@ABCB@@CBABA@@DAD@DAB@D@B@@@BDB@@@B@B@BBB@B@B@B@@@B@@@@@B@@@B@@@B@@AB@@A@A@A@@@@BA@@@@@AB@@AB@@@@@BA@@@@B@@A@@@@BC@@@@@A@@@@@@A@@AC@CAA@CA@@@@A@AAA@AAAAA@@@@@AAAA@@@@AA@AAA@AAA@@AAACA@AA@@@A@@AA@@@A@@@A@@BA@@BC@@@A@A@@@AB@@@@@@@BBBBB@BBB@B@@@@@B@@@B@DCB@@@B@@@BA@@B@@AB@@A@@@A@@@A@@@AAAAAA@@A@@@@@@@A@@@AB@@@BAB@B@B@@@B@@@@@@@AAA@@AA@@@@@@A@A@A@@@@BA@@DAB@@A@@B@@@B@@@BA@@B@@@@@BA@@@@@@BA@@@A@@@@@A@A@A@@@@A@@A@@@A@@@@@A@@@@@A@@A@@A@AA@@@@A@@@@A@@AA@A@@@AA@@@@A@@AA@@@@@@A@@A@@@@@@@@@@@@@A@@@@@@@A@@@@@A@@@@@A@@@@@@@A@@@@@@@@A@@B@@@@A@@@@B@@@@AB@@@@@B@@@@@BA@@B@@@@@B@@@BA@@B@@@B@B@@@@AB@@@B@@@@A@@B@@@@A@@@A@@BA@@@AB@BA@@@@@A@@@@@@@A@@AA@@@A@A@@@@@@@A@@@@@@@A@@@@@A@@BA@@@AB@@@@@B@@@@AB@@@@@B@@AB@@@BA@@B@BA@@@@BA@@BA@A@@@@B@@AB@@@@@@@@A@@@A@@A@@A@@A@A@@@AA@@A@AA@AA@@AAA@AA@@A@@@@@@@ABA@@BA@@@@D@DAB@@@DAB@BA@@BA@@BA@ABABA@@@ABAB@BABAB@@AB@FAD@@@B@@@BABA@@BABA@AB@@AB@@A@@BA@@@A@A@A@A@CAA@AAA@CACA@@CAAACAC@AAA@CB@D@BBF@FBDBDBBB@@B@B@B@BADAB@@@BA@@B@@@B@BBBBB@@@B@@@@AB@@@@ABA@ABA@A@@@A@AA@@AAAAC@AAA@AB@@ABA@@@AA@@A@A@E@@@AA@@AA@C@@@AACCAA@A@E@A@AC@AAA@@AAAAAC@E@A@A@@@@@ABA@A@CAA@A@ABA@A@ABEDE@A@AA@@CA@@A@C@CAA@ABC@ABA@A@AACAA@A@A@C@EAA@ABED@@C@@BA@CDA@A@CB@@A@@BAB@@@FAB@@@@A@A@@BA@@@A@@@@BA@C@@@A@@@ABA@@@AAA@A@A@A@A@C@C@@@@@A@@@@@ABA@@@@@A@@AA@@@A@AA@@@@@@@@A@A@@@C@@@CAA@@@A@AA@@A@@@@@A@@AA@@@@AA@@@AAA@A@@@AA@@@@@@CAA@AAA@AAA@AAA@@@AA@@@A@@@@AA@@@A@@@A@@@AA@@A@@@A@A@@AA@A@A@@@@@@@A@@BAB@@A@@BA@@@@@@@A@@@@@@AA@@A@A@A@A@EAA@@@AA@@A@@@A@A@AAA@AA@@A@@AA@A@A@CAA@A@@@A@A@C@@@@@A@A@@@A@A@A@A@A@A@@@A@@@AA@@A@@@AAA@@@A@A@@@A@@@@@A@@@CAA@A@@@A@@@@@A@@@AB@@A@A@AB@@AB@@AB@@A@@B@@AB@@A@@@@@@@@B@@@@@B@@@@@@AB@@@BA@@BA@@B@@@BAB@@BB@@@@@@B@@@BB@@@@@@@B@@@@@BA@@@@@@@@@A@@@A@@B@@AHABAD@@@BABCB@@AB@@@@C@ABA@E@AAEA@@AACAAAA@@@@AA@A@AACA@@A@@@A@@@@@@BA@@B@BA@@BA@@B@@A@A@AB@@A@@@AB@@A@A@@BCB@@A@@BA@@@AB@@@@A@@@A@@@AB@@@@@B@B@@AB@@@B@@@B@B@@@B@@@BA@@@A@A@AB@@@@@B@@ABABA@@BA@@B@@@BB@BB@@BBBB@B@@@@ABABCB@BAB@@@@@@ABA@ADAB@@@B@BAB@@@@AB@@BB@@@@@BAB@@ABCDA@@BA@@@C@@BA@@@AB@@@@@BC@@@A@AB@B@@@@@@BB@@BBB@@BABAB@@AD@@@B@@@D@DAB@@@@@@CB@@C@C@E@A@A@@@A@ABA@@B@@@@@B@@AB@BA@@DA@@B@@@B@@@B@@A@@@@@ABA@CBC@CBCBEBA@A@ABC@@@@@A@@B@@@B@BB@BB@B@@@B@@@BAB@@AB@@AB@@A@ABA@C@A@A@C@@BA@A@@BA@A@A@A@AB@@AB@@ABCBA@AB@@AB@@@BAB@BABAB@B@@BB@B@@@@FBB@BBD@F@B@B@@BD@@BBB@@BF@F@D@@BB@@B@B@B@@@B@@@@BB@@B@@B@B@@@@@BB@@@@@B@@@B@BBB@@BBDDBBBB@BBB@@@B@BB@@B@B@@@@@@BA@@B@B@BAB@BABABABAB@B@B@B@B@D@@BB@@@@@A@AB@B@@@B@@@@BBB@DB@@B@@B@BB@B@@@@@@@BAB@@@@@@@B@@@B@@@@B@@BB@@BBB@BB@B@B@@@B@B@@@B@BB@@@AB@B@@@@@BB@D@BBB@@B@@BB@@@@B@@@B@B@B@B@DB@@B@B@BAB@@@@AB@@@B@@B@@BBB@@@@B@@@@@B@B@@@BD@@@@B@@@@@B@@AB@@@B@@@@BB@@BBB@B@BB@@FB@@@@@@@@A@A@@BA@@@ABA@@@@@@@EB@@A@A@A@@B@@@@@@@BA@@@@@@BA@@@@BA@@BAB@@@B@@@BBB@F@B@@@BA@A@A@@B@@@@B@B@B@B@BAB@B@@@B@BB@AB@D@@@B@B@B@B@@@B@@BBBBB@B@@@BAB@B@D@B@@@@@@B@D@J@B@D@F@@@@@BBB@@B@B@@@@@BC@AB@BB@@@B@@BB@BBFB@@B@BAB@B@@@B@B@@@B@@BB@@DBB@D@B@@@@@BB@@@B@@@@@BB@B@BB@BBBBBD@BBBBB@@@@B@@@B@B@@AB@BABABA@@B@@@B@B@B@B@B@B@B@BAB@B@@AB@@A@@"],"encodeOffsets":[[133853,46289]]}}],"UTF8Encoding":true});}));