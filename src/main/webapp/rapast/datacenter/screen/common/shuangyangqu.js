(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('双阳区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"220112","properties":{"name":"双阳区","cp":[125.659018,43.525168],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@@@A@@@@@A@@@@@A@@@@BA@@@@@A@@BA@@@AB@@@@@@@@@@A@@@@@A@@@@@@A@@A@@@@@@B@@@@@@@@A@@B@@@@ABAB@@@B@BAB@B@@AB@@@DCBEBIFA@A@CBCBE@CB@@A@ABCBC@CBAAABEBCBAB@BABC@C@CBABC@A@ABEBA@CB@@AB@@@BEF@BABABAB@@ABEDCBABA@@@CBA@CBA@AB@@A@A@I@ABA@C@ABABAB@@CDKHABIFABCDA@@BABCFAB@@AB@@A@AB@B@@CDEBC@CBCBGBAB@BAB@B@B@BA@ABADABAB@BCBABABA@@@@@@BA@@@@@AB@B@@@@BB@@B@B@BB@@B@@B@@BB@@@B@@@BB@@@B@@@B@@B@@B@D@B@DBFB@B@@@B@@B@@@@B@@B@@@D@B@B@B@@@BBB@BBB@DBB@DBD@@BB@B@@BB@@BB@@@BB@@BBB@@@@BBB@@AB@@A@@@A@ABA@@@@B@@B@@B@@@B@B@B@D@@@B@B@B@@@B@@A@AB@@@B@@@@B@@BB@@@B@B@@BB@@@@@@@@B@B@@AB@@@B@B@@@@ABA@@@@@ABA@@BA@@B@@A@A@C@C@C@AAC@AAC@A@E@A@EACAAAA@@AA@@@ABA@@@AB@@A@@B@@AB@@B@@B@@@BB@@B@@B@A@@BA@A@C@C@A@A@A@A@AAC@@@A@@@A@AB@@A@A@ABA@@@@AA@AAA@A@A@C@C@A@AAA@A@A@A@@BA@@B@@ABA@@B@@@BAB@BA@@@ABA@@BC@AAC@A@A@@BCDA@@BCB@DBBDD@@BBBBFBHD@@DBDBFB@@BB@@@@@@@B@@A@ABCB@@@@@B@@@@B@@BB@@BB@AB@@@@@BA@A@CBA@A@@@A@A@A@ABAB@B@@@B@@B@@@@@B@@B@@@@@BAB@BA@ABEBC@ABA@A@@@CAA@A@@BA@@B@B@B@B@@@BBB@B@B@BA@@BB@@BB@BDBBBDDB@B@@@B@@A@A@A@A@ABABAB@BABA@ABABA@CBA@@@@@AB@@@@ABAD@B@@@@@@@B@@@B@@@B@@@@@@@@@BA@@BA@ABE@A@ABC@@@A@AB@@A@@BA@@@ABA@@BA@A@@B@@A@@B@B@@@B@@@@BBB@@BB@@@B@@@@B@@AB@B@@@B@B@B@@@BBBA@AB@B@@@BA@AB@B@BAB@B@B@B@B@BA@AB@@ABEBABABABABAB@@@B@B@BBBBBB@B@DBB@@@@B@BB@@B@@@B@BBBBD@BA@@BAB@BBBAB@@BB@@B@@B@@BB@@AB@B@@AB@B@@@BB@@B@BB@B@@@@B@@@@@B@@@B@@@@@BA@A@@BABBB@@@BAB@DB@ABA@@@ADABABBBBBAD@@@B@B@B@@@@@BA@@BAB@B@@@D@B@BBD@B@DBFA@@D@@A@A@@@@@BB@@@@A@@@AB@@@B@@@@@@B@JBCDB@JCBDB@@@B@BBDB@@@@BBDBB@B@D@D@@BB@@@BB@@BBB@BBB@@@B@@@@E@A@A@@@ABA@AB@B@@@B@B@BBB@B@D@B@@@B@BB@@@@@@@B@@@B@@@@@B@@@@D@@B@BFABAD@BD@BB@@@@B@@@@@B@B@D@@@@A@A@A@@@A@@B@@BB@BB@@BB@B@@BB@BB@@B@@BB@@@@@@BB@@@AB@@@B@@@B@@@@A@@@AB@@@@@B@@CB@@@@@B@@@D@BBB@@C@A@A@A@@@@@@BD@F@BBA@C@C@DBBBDDB@BB@@B@BBB@D@B@@@@B@D@@@@A@C@@HJAAFA@@@BB@@BB@B@@BB@@@B@B@@@B@@@@A@AD@@ABC@@BC@AA@@A@A@A@A@@@A@AA@@A@@@A@@AA@A@@@A@A@CBA@ABABABAD@@@BB@@@AB@@A@AAA@AA@@A@@@AB@B@@@@@@CBABA@CBA@A@@@@@B@@BB@@@@@@@@B@@B@@@@BB@@@DDBBBBBB@B@BAB@BABA@@@A@@@@@@@AA@@@B@@@B@@@D@@@@ABCBA@A@@@A@@@A@@@AA@B@B@B@D@BBBBB@B@@BBB@DB@@B@D@@@BABBB@@@BBBBD@BBB@D@B@B@B@D@BBDB@@B@@@B@@@@@@@B@BAB@@@@@B@@@DCBA@@DBBBBD@@@@@@@B@@AB@@A@@@@@B@B@@@B@@@B@@ABA@@D@B@B@B@BBD@D@@BA@@@@@@BA@@@A@@@@@@@@BBBB@@@@@@B@@BB@@@@BBDBB@@@B@@@B@B@@@B@@@@@B@@@@@@B@@@@@B@B@@@B@@@@B@@BB@DB@@@B@@@@ABB@@@B@@@B@B@B@@@B@DBD@B@@@B@BA@@@@BBB@B@@B@@@@AB@@B@BB@@@BB@@@@@@@@B@@AB@B@@@BA@AB@B@@BB@@@B@@@BA@@@@B@BB@@@BBB@@BBBB@@@B@D@DAB@@BBBBB@@@B@BA@CBCDCB@@@B@B@@BB@B@@ABABAB@B@@BBB@@BD@B@B@@@B@@BB@@@B@@@@@B@@@@@@@@@B@@@@B@B@@@@B@B@@ABA@@@@@@@@@B@@@BB@@@B@@AB@B@B@FAB@B@@@B@B@BB@@B@@@B@@@@@B@@@B@@@B@@@B@B@@@@@@@@@B@@@@AB@@@@BB@@@B@@@B@@@@@@@@@B@@@@@@@@@B@@@@@@@@@@@BA@@@@@@B@B@B@@@B@B@BA@@@@@@@BB@@@BB@@@@@BB@@B@B@@@B@@BBBDDD@@@BA@@@AB@@A@@@A@@@@@@@@BB@BDDB@BB@@@@@@@B@B@@@@@B@DAB@B@B@@@B@BBBB@@BB@@B@B@B@BA@@@@@@B@@BB@B@BB@@D@@BB@@@BBB@B@BBB@BB@@BB@B@BBB@B@@B@@@D@FABAD@@AB@@A@A@@D@B@B@@@B@FBDBD@B@BB@BBBB@BB@@BBB@DBB@BBB@@BBB@@@@BBB@@@D@FBD@D@D@B@BAB@B@BAD@@@B@B@B@@@B@B@@@@@BB@@@@@B@B@@@@@B@B@@@@@B@@@@B@@@@BBBB@BADCDAB@B@BAB@B@@@D@@AB@B@B@B@BAB@B@B@B@BAJBB@B@D@BABA@A@@@ADAD@@ABABAA@@A@A@@@@@@B@@BB@BBBBB@FDB@@@@@@A@@@A@@@@AAA@A@@A@@B@@@@AB@@@@@@@B@@A@@@A@ACBC@@AA@ABA@A@@@@@@A@@@@@@@A@@@@A@@@@@@@@@B@FABAB@B@BAHA@@@@B@A@ABDBFB@@@@@BAD@@B@@@@@B@@ABC@@BA@@@AB@@@@B@@@@AD@@HB@B@@@@JBBABAB@BA@@BC@@A@CAA@@AB@CABA@@CAA@AA@@@@@@B@@A@@@@B@B@@@A@@A@AB@@@@@AA@@@@@@@@@@BADBBBBB@BD@H@BBB@B@@BD@F@D@F@B@B@BBBB@@DABAB@@BBB@B@@BBB@B@AD@@BBBBBBB@@BA@ABCBA@CDAD@@B@DBB@B@DBDA@@@AFABAB@@@@AB@BA@@B@@@BBB@@@BA@A@@@@AAABA@AA@@@@BA@A@@BAB@B@BB@A@AB@B@B@B@@AA@@A@@BABAA@A@@AAAAA@BABC@A@@A@A@@AA@AA@AA@A@@@@@AB@@@BB@@BA@@@@@@B@@@@@@@BBB@@B@@B@@A@@@@AA@@@@@AB@@B@@BA@@@@@@AA@A@@@@@A@@@@A@@@A@@A@@BA@@@@AA@A@@@@@AB@@@@BB@@@@@@@AB@@@@BB@@B@@A@@BA@@@@@@@@B@@@B@@BB@B@B@@@B@@ABA@@@AA@@AA@AA@@@A@@BA@@BA@@B@@@@@BB@@AB@@B@@B@@F@B@@@@ABA@@@A@A@@@@A@@@A@A@@@A@@@@AB@@@BAB@B@@@@@BAA@@A@@@@AAA@@@@A@@@ABABC@A@@A@AA@@@A@A@@FC@@@A@@@@@A@@@A@@@AB@@@@A@@AA@A@@@AB@@@@@@@@BBB@@B@B@@@B@@AAA@@@ABA@@B@BAB@@ABA@A@A@A@@B@BA@AB@@@AACA@@@A@@BABABA@@BAA@@A@A@ABA@@D@B@@@@A@@@@BA@@@ABA@@@A@@@AA@@@ABA@AA@@@@@@@@BA@@@A@ABA@@BADA@ADAB@@@@AB@@@BBBD@@@@B@@@B@@A@A@@@@@@DA@AB@@ABAB@BA@@B@@BBBB@B@B@@@B@@A@@@A@@@@AAA@AA@@@@@A@@B@BA@@@@@AA@@@A@A@@@AA@@BA@@BAA@BA@A@@BAB@@@BA@@@A@AB@@@BAB@@@B@@@BABABA@@@@@A@@AAA@@@A@A@@@AA@@@@@A@@@@B@@@@@B@B@@@BA@@@A@A@@@@AA@@@C@@@AB@@AB@@@BAB@B@@A@@@AAA@@@@AAA@AA@@A@@AB@@ABA@@B@@@@@BBB@BBB@@@BADAD@@ABA@@AAA@@A@@@@B@BA@A@@AAACBC@AAE@@A@@ABAB@DADCBE@CBCA@C@ABC@@CBAAAAAAA@CBABA@C@CBABC@A@ABCD@BABAAAA@ACCCAAAAAA@AAA@A@@@C@ABE@A@CA@@@@C@@CAC@A@AA@AB@BA@A@E@@@@AAAA@@C@A@A@A@@@AA@@@@BA@AB@B@B@B@B@B@@@@@@ACAAA@@@AB@@A@@@AAAC@@@A@A@A@A@C@AAAAAA@A@@BA@A@A@AAACAAA@@B@BAFABA@@AAAC@AAAA@GCCAA@AAA@AACA@@@AB@@ABA@A@AB@B@D@D@@A@@@A@@@ABAD@DAD@DAB@@A@A@@@@A@A@C@A@@AAC@ABC@EAC@EA@@AA@CAAACE@ACA@AA@ABA@AAA@@A@@@A@A@A@@@ABABA@@B@B@D@BAB@@AB@@AB@BA@@B@B@D@B@@AB@@@AAA@AA@@@A@A@@@A@A@AB@@@BBB@BB@@B@BA@@BA@ABABA@A@A@AAA@@@ABA@@BCB@B@BA@@BA@@@A@@@AACBA@@@AB@B@@E@A@@AAAC@@@AB@BAB@DDB@B@BAB@DCBCB@BAD@DAH@H@B@B@BABAB@@@BB@B@@B@B@B@@@@ACCAABABABA@@DA@AD@DAB@BA@A@C@@@@BA@@B@DDB@B@DABA@@BADAB@B@B@BDB@B@@@B@@ACA@A@C@C@@@AB@D@DA@ACCAA@ADA@@DA@@@ABA@A@@@A@@@@@A@A@@BA@@@@B@@@@@@AB@@@BAB@@@BA@@@A@@@@AA@@@A@@@A@@@@@@@@B@@A@@@A@@@A@@@@BC@@@@BAB@@@B@@A@@@@@ADA@@@@@@B@BBB@B@BBB@B@BABAB@BAB@BBB@BB@@@BB@@D@@@@@B@@B@BB@@B@@@B@B@BAJ@B@D@@@DABABADA@@@A@@AA@A@A@ABABAB@B@@@BA@A@A@A@A@A@@A@@@BA@AB@@@@A@ABA@AB@@AB@@@@A@@AA@@AA@A@@@AB@BAB@@@F@DBBAB@@AD@BADAB@BA@A@A@A@@@A@AB@DCDCB@@AA@@ACC@A@A@A@AB@@AA@A@@AA@@AA@@@A@@@AAAA@@@@A@@A@@@@A@@BC@@@A@@@@AAA@A@A@@@@A@@@A@@@A@ECC@CAA@A@C@AA@@AAC@CAC@A@AA@@A@AA@@A@@AAAAA@B@@@@@B@@ABABABEBEDCBAAA@CACAACC@@AA@BA@@@AB@@A@A@AAAAA@@@@A@@A@CA@CAA@@@A@AA@AAA@@AAA@C@A@E@CAICC@CAAA@@A@@@A@ABABA@@@A@AAA@AAA@C@EAA@A@@@@ABCBA@A@A@AA@CAC@G@AAG@AAA@CAECAAAACAA@E@CAGAC@C@GAA@G@C@C@A@A@A@AAAAA@CAAACBA@@@@@A@CAA@A@C@A@@@CBABAD@@ABE@C@CBA@ABABAB@DA@AB@@C@CBCDAB@BAB@@CBAB@@@B@BA@A@C@CAGCCAEACAA@@A@@AAAAECCAAACAAAACAAAC@@EC@AAAA@C@CAA@AAAAAAC@A@AAEAA@AA@@A@A@CAE@@AA@AACACAC@AAA@C@A@A@A@@@CA@AA@AAA@C@AA@@A@AAC@C@A@A@@@@@A@@@AB@@@@@@AAE@@@A@A@@@@@A@@@@A@@@@@A@@@A@@@A@@AA@@@@@A@@@A@@@A@@C@C@A@CAA@A@A@A@@@CAAAC@EAA@"],"encodeOffsets":[[128715,44302]]}}],"UTF8Encoding":true});}));