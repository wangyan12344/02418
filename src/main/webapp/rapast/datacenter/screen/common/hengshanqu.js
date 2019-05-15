(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('恒山区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230303","properties":{"name":"恒山区","cp":[130.910636,45.213242],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@B@@@@@B@@A@@@ABA@@@A@@@A@@B@@A@@B@@AB@@@@@B@BAB@@@@@BA@@D@BA@@BA@ABABA@AB@@ADI@ABB@@B@B@@@B@B@@@B@@B@@B@@BB@@@@@@@B@BA@@@@B@@@B@B@@@@A@@@A@@@AAA@@@A@@@A@A@@@AB@@A@@BA@A@@@AB@@AB@@A@@AAA@CAA@A@@@CB@@A@ABA@A@A@@@ABA@AA@@AA@@AAA@AAA@@@A@A@ABA@AB@@ABA@A@AB@@@@A@@@AC@AAA@@AAC@@AA@CCAAA@CAAA@@AAAA@@AAA@@@@@AACCAA@@EAAA@@A@CCCAEACA@@AA@@@A@E@@AA@A@@@A@@B@@@BAB@B@BAB@BAB@BA@@@A@@BA@A@@@@BADB@@BA@@B@@@@A@@BA@@BAB@BAB@B@B@@@B@BBB@@@B@B@@@B@B@@@B@B@@@B@BBB@B@@@B@B@@A@@@ABA@A@A@@@@@A@@A@@@@A@@@@@AAA@@CA@@@@AA@@@@@@@A@@@@@A@@@@B@@AB@@@@@@@@@B@@@@A@@AA@@@@@AA@@AAA@A@@@@@@AAA@@A@@A@@A@@A@@@@@A@@AA@A@A@@@@@A@@AA@@@@AA@@@AA@@@AA@AA@@@@@@@@AA@@@@A@@AA@AAAAA@@AA@AA@@A@@@@@@A@@@@@AA@@@@A@@@@@A@@@A@@A@@A@@@@AA@@A@@A@@@@@@A@@AA@@@A@@A@@@@AA@@@@@A@@@@@@@@@A@@@A@@@@@A@@@@@@AA@@@A@@@@AA@@@A@@@@AA@@@@AA@@@@@@A@@A@@@@@@@A@@@@@A@@@@A@@A@@AA@@@@AA@@@@@@@AA@@@@@@@@AA@@@@@@AA@@@@@@A@@A@@@@AA@@@@@AA@@A@@@A@@@@@AA@@A@@@A@@@@@@@AA@@@A@@AA@@@@@A@@@@@A@@@@@A@@@@BA@@@@@AB@@@@@@A@@@@@A@@@@@@@@@A@@@@@@BA@@@A@@B@@A@@@@@@@A@@AA@A@@@@@ABA@@CCCAAACAAAA@@ABC@A@A@C@C@@@A@ABABGBA@ADABAB@BA@@B@B@BABABAB@BABAB@BC@@@@@@B@@A@@@@@@@AB@@@@@@@@@@@AA@@@@@@@A@@@@@A@@@@@@@A@@B@@@@A@@@@@@B@@AB@@@@@BA@@BA@@@@@@@A@@@@@@@A@@@@B@@@@A@@@@@A@@AA@A@@@A@@@@AA@@@@BA@A@@A@@AA@A@@@AA@@A@@AA@ACA@@@AAA@@AA@A@@AA@@@@AAA@@@AA@@ACAA@AACACAAAA@@AA@A@AAAAA@AAA@AA@@AA@A@AA@ACAAA@AA@@AA@@A@@AA@@@A@@AC@CAA@A@AA@AB@@@@@@@@A@@A@@A@AA@@@AAAAA@@@AA@AAA@A@@@ABC@@@AAA@@AA@@AA@@AA@@AAA@AA@@A@C@ABA@@@CBA@A@C@A@A@C@ABA@A@A@EACAAAC@AA@@@AAA@@A@EAA@AAA@A@A@A@C@A@A@@@C@C@A@@AA@EAAAGCAAA@E@A@KD@B@@A@ABE@A@A@ABA@ABADCFAB@@@@@BA@A@@@@@@B@@@@@@@@@B@@@@@@@B@@@B@@B@@B@@B@BBAB@@@@A@A@A@A@@@@@@B@B@F@BBBDDBB@@D@B@@BB@@B@@@F@B@BB@@B@@AB@BA@@BBB@BBDBB@BB@@B@B@@@BAB@BAB@B@@A@@B@@A@@@A@AAAAA@@@A@@@AB@@A@CBABA@A@A@@@AACACAEAE@AAC@A@@DBB@BBDBDBB@DB@BD@DBB@BBB@D@B@B@B@B@@AB@@@BA@@BA@@BABAB@@ABAB@@A@@@C@EBA@@BA@ABABA@AB@B@@ABAB@BAB@@AB@@ABA@CB@@A@CBC@@@@@AB@@AB@B@@@@@@@BB@@BBB@BB@@BBBB@@@BB@@B@B@@@@BB@@@@B@@@B@@@@@@A@@BA@@@@@@BAB@@AB@@@@ABA@@@AB@@A@@BA@@@@@A@@B@@A@@@@@A@@B@@AB@@@B@@@@@B@@@@@@@B@@@@@@@B@B@@BB@@@B@@@@@@@B@@@@ABA@@B@@AB@@@B@@@B@@A@@@@B@@A@@@A@@B@@A@A@@@A@@@AB@@A@@@@@A@@@AB@@@@A@@@@@A@@B@@A@@@@@@B@@A@@@@B@@@@@@B@@@@@@@B@@@@@B@@@@@B@@@@@@@B@@@@@@@@@@@@@B@@@@B@@@@B@@BB@@@@@BB@@B@B@@BB@@@@@@B@@B@@B@BB@@@@B@@@@@B@@@@@B@@@BB@@@@@@B@B@B@@@@@B@@AB@@@@@@AB@@@@A@@@AB@@A@@@A@@@@BA@CB@@AB@@@@@B@B@B@@@@B@@BB@BB@@@@@@A@@@A@A@A@AB@@A@@B@@@B@@@@@@@BB@BBBB@B@@@B@@@B@@@BA@@BA@@@AB@@A@@@A@CDA@@@A@@@@@A@A@AAA@AAAA@@@@@@A@@B@@@B@B@@AD@@AB@@@B@@@B@@BB@@@B@@BBB@BDBB@@BB@BBB@BBB@@@@BBBB@@@@B@BBBBB@BBB@@@@@DBB@DBD@@BB@@@@@@@@B@@@@AD@@@@@BA@@@@@AB@@@@A@@BA@@B@@@@AB@@@@@B@B@BA@@BA@@@A@@@A@@@@@A@@@A@A@A@A@AAA@A@@@A@AC@@A@C@A@CBC@CB@@ABAB@DA@AD@B@D@B@DBD@BBB@B@B@B@@A@E@@@A@@@A@@@A@ABA@A@A@@BA@A@C@A@A@A@A@A@A@CBA@AB@@C@@@CAA@AAA@AA@AAC@@BA@A@AAA@AA@@@@C@C@A@EBA@@@A@A@@@AA@AAC@CAA@@@A@@@EBCBA@A@@@@BAA@@@@@@@BA@@@@@ABA@ABC@@@CBA@A@A@ABA@A@A@@@CBA@C@A@@@A@@BC@AB@@AB@@@B@B@@AB@B@BAB@BA@A@@@ABAAC@A@A@A@AA@@AA@@@@A@ABA@C@A@@AA@AA@@@@@B@B@@@B@@@B@@@B@@@B@@BBB@BB@B@@@B@@BBB@BB@@BBD@BB@@BBB@BB@@BB@@@B@@@B@@A@@B@@@@@B@BBB@@DB@@FD@BB@@@BB@@@@BBBBBB@@@@@@@@A@@B@BA@@@@@@B@BB@@@@@@BBB@@B@@B@@@@@@@B@@@@@B@@A@@B@@@@@B@@@@@B@@@@@@@@@@@B@@@@@@BB@@@@@@B@B@@@@@BB@@B@B@@BBB@@BBFB@@@B@B@@@B@B@@@@@BB@@B@@@@@B@@@B@B@@A@@B@@AB@@@BA@@B@@@@@B@@@@@B@@@@@B@@@@@@@@@B@@@BAB@@AB@@@@@@@B@@@@@BB@@BBB@@@BB@BB@@BB@@B@@B@@@BBB@BBB@BD@BBBBB@BBB@DFFDDDHHDDBBBBBB@@BDBB@B@B@DB@BP@@BB@@B@@@B@DAD@BA@@B@B@B@@@B@@@B@DB@@B@@@B@@@DABAD@BAB@BA@@B@@@@@B@@BB@B@BD@@FBBB@D@B@F@@@@BBBD@BBB@BB@@@BBB@@AB@F@@@B@B@BBBB@BB@DBHBDB@@DBB@BBFAF@B@BBBABABA@@DA@@@@@@@A@@AA@@@A@@@A@@BABA@@@@@AB@@A@@@@DA@@B@@A@@@@B@@@@@@@B@@@BB@@@@@@B@@@@@B@@@@A@@B@@ADA@AB@DAB@@@B@B@B@@A@@B@@@@AB@@@BA@@@AB@@AB@B@BAB@B@B@BAB@BAB@@@@@@A@A@A@@@A@AAA@C@@@@AAAA@@@@AA@A@@BA@@@A@A@AAA@@@A@A@A@@AAAAA@AA@A@A@A@ABA@A@AAA@@@@@@@@@AB@@A@@@A@@B@@AB@@@@A@A@@AA@@@AA@@@A@@A@@AA@@AA@@@AA@@A@@@@@AB@@A@AA@@@@A@@A@AAA@@AA@AA@@@@@A@@@@A@BA@ABA@@BA@@@@AA@@@A@A@@@A@@@@B@@@B@B@D@@@B@B@B@@AB@@@@@@@BA@@@CB@D@D@@@@@@@@@@ABA@@@@B@@@@@B@B@@@@@B@@AB@BA@@D@B@@@@@B@@@BA@A@@@@@@BB@@@BB@@@@@B@B@@@@@B@B@@@@@B@@@@@@@BA@@@A@A@A@@B@B@@@B@B@B@@@B@@@BA@@@AB@@ABA@@@@@A@@@@@@@ABA@@@@B@@@B@@@B@B@@@B@FBDBDB@@B@@@B@@@B@@@B@B@@B@@B@BBBBB@B@F@D@@@@@@@@@B@@BBBB@@BB@@@@@@@B@@@@B@@@BB@@@BBDBBBBBB@BB@@@B@@BD@@@B@B@B@B@@@@B@@@B@B@B@BAD@@@B@DAB@B@B@D@B@DAB@@@B@D@B@B@@@B@BAB@B@D@@@B@@@B@B@B@B@B@B@@@B@B@@@@@B@BAB@BAB@@@@@@@B@@@@@@B@@@@B@@@@@BA@@@AB@@@B@@@B@@@BBB@B@@@B@B@@@B@BB@@B@@@B@BADB@@B@D@@BB@B@@@B@@@B@@@@AB@@@B@@@@@B@B@@@B@@@@AB@BA@@@@B@B@@@@@B@BAB@@@B@B@@@D@DB@@@@B@BA@@@@B@@@@B@@F@F@F@B@B@BA@@D@B@DA@@@@B@@@@BBB@@BBHDFBDBBBB@"],"encodeOffsets":[[134216,46335]]}}],"UTF8Encoding":true});}));