(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('通化县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"220521","properties":{"name":"通化县","cp":[125.753121,41.677918],"childNum":2},"geometry":{"type":"MultiPolygon","coordinates":[["@@@@B@B@D@F@HBD@D@BADAB@D@DB@@B@@CBCBA@@@@@@DADC@@BC@A@@B@@@@@@@@@B@@@BAL@@A@@@@@A@@@@A@@A@@@AA@@AA@@C@@@A@@@AB@B@B@@@B@@@B@B@@@BAB@B@B@@@@@B@@@@@B@BB@@B@B@@AB@B@BA@@B@B@@B@@BB@@B@@@BB@@@@B@@@BA@@B@BBB@B@BBB@@@B@@@BA@@B@@@@@@BB@@@@@F@B@B@@@BBB@@@B@@@B@@@BBBBB@@@@@BB@BBB@BD@BBB@@B@@BB@@@BA@ABAB@@@B@B@@B@@BA@@@A@ABA@C@@@@BA@ABCB@BA@@B@@@BA@ABB@@B@@B@@B@B@@B@@@BB@@BB@@@B@@@BAB@@ABC@@B@@@BB@@@BBB@@BB@B@@@DAB@@AB@BA@@B@B@@@@@B@@A@@B@@@B@@@B@@@B@BB@@B@BB@@B@@@B@B@B@B@B@@@@B@B@B@B@B@D@@@@BDBBBB@@@@@B@@B@B@D@B@B@@B@@@B@@@BA@@B@@@BB@B@B@B@B@@B@@@@@B@@@@@B@@BB@@@B@@@@B@BB@@BBB@@B@BB@BBB@@B@@@@BB@@B@@@DAD@B@DBD@BBB@@@@B@@@@@B@@BB@@B@@B@@BB@@@@@BB@@@@@B@B@@@@@@@B@@AB@@@@AB@@@BA@@@@@@BB@@B@@A@@B@@@@AB@@@@@@@B@@@B@@@B@@AB@B@B@DB@@@@@@@@@@B@@@@@@@B@@@@@@@@@BB@BB@@@@@@@@@B@@@B@@@B@@BB@@B@@@@@@@@@@@BB@@@@BB@@@@B@@B@@@@BB@@@@@@@@@B@B@@@B@B@@@B@@@@@B@@@@@@@@A@@@@B@@@B@@@@AB@@ABA@@@AB@@@@A@@A@@A@@@A@@@@@@@A@@B@@@@@@ABA@@@A@@@A@A@@@@@@@A@@@@@@@A@@@@AA@@@@@A@@@@@@D@@@B@@@@@BA@@@@B@@@BAB@B@@AB@D@BABAB@B@@A@@B@@@@@@@@A@@@@BA@@@@BA@@@@@A@@@@@@AA@@@@@@B@@@@AB@@@BA@@BA@@B@@@@@@@BA@@@@@@@@B@@@@@@@@A@@@@@A@@@@@A@@@@@@@@@A@@@@@@@AA@@@@A@@A@@A@@@@@@@A@@@@A@AA@@@@AA@@@@@@@A@@@@B@@@@AB@@@@@B@@A@@@@B@@@@@@AB@@@B@@A@@@@B@@A@@@@@@@@B@@@B@@@@@@@AA@A@@@A@@@@@@@A@@B@B@@@@AB@B@@A@@B@@@@A@A@@@AB@@@@A@@B@@@BA@@@@B@@AB@@AB@@@BA@@@@B@B@@@@@BA@@BABA@@@@B@@AB@@@@@@@@A@@@A@@BA@@@A@A@@BA@A@@@A@@@@@A@@@A@@@A@@@@@A@@@@@@B@@A@@B@@@@@@@@@B@@@B@@@@@B@@@@@@@B@@@B@@@@AB@@@@@@AA@@A@@AA@@@@@@@A@@@@@A@@@@@@@@BAB@BAD@BAB@D@@@@@B@@@@@BB@@B@B@BB@@B@B@@@B@BBB@B@@@@@B@@@B@@@@@B@@@@@@@@@B@@@@@B@@@@@B@@@B@AA@@@@@A@@@@@AA@@A@@B@@A@@@@B@@AB@B@B@@@@@B@@@@@B@@@@A@@@@A@@A@@@@@A@@@A@@@@@@@A@@@@@@BA@@@@DADA@AB@@A@@BAB@@@B@@@B@@@B@BB@@@@@@B@@@@@@@B@@@@A@@@@B@B@B@@@B@@@B@@@B@@@BB@@B@BB@@@B@@@@@@@B@@@@@@@@@@@@B@B@@@B@@@@@BB@BD@@@@BB@@@B@@@@@B@@B@@@@BB@@@@@@@B@@B@@B@@@@A@@@@@A@@BA@@@@@A@@@@@@@AB@@@@@@BB@@B@@BB@@@@@@B@@B@@@@@@@@@B@@@B@@@B@@@B@BA@@B@B@@@@BB@@@B@B@B@F@@@@@B@@@B@@@BBB@@B@@BB@@@B@@BB@@@@@@@@B@@@@A@@B@@AB@B@B@@@B@@@@@B@@@B@B@@BB@@@B@@BB@@@B@B@@@B@@@B@B@@@B@BB@@@@BA@@@@@A@@@@B@@@@@BA@@B@@@@@B@@@B@BBD@B@BBB@@@@@B@@@B@@@@@@@BA@@@@B@@AB@@AB@@@@@B@@@@@B@@@B@B@@@@A@@B@@@FA@@B@BBBB@@B@BBBA@@B@@@@BB@@@B@@BB@@@B@@@BBB@@B@@B@@BB@B@@@B@@@@@B@@A@@B@@AB@B@B@B@B@@@B@@@@@@BB@@@@@B@D@@BB@@@@@B@@BB@BB@B@@@@B@B@B@B@@@B@@@BA@@B@B@@@@@B@@A@@BA@@@@@AB@@AB@BA@@B@B@@@BA@@@@@@BA@@B@DAFCDBD@B@F@B@@@BBB@B@@@BBBBB@@B@@@B@B@@@@@B@B@@@B@BA@@@@@B@@@B@B@B@@BB@@BB@B@@BB@DB@BB@BB@@B@BAB@BAB@B@BB@@D@BBB@BBB@B@BBB@BB@@@BAD@@AD@@@B@@@@B@BBB@@@@@@B@B@@@@BB@@@B@D@B@@@BAB@BABA@AB@B@@BB@BFDD@BBBB@@@B@@@@@@@@A@@@@BA@@@@@@@@@@@@@@@@@A@@B@@@@@@@B@@@@@@@@ABABAB@@AB@@@B@@@BBB@@@B@@BBB@@A@@BABA@@DAB@DAB@BABBD@B@@AB@@AB@@BB@@@B@@@BABA@@BAF@B@B@DC@@@@B@BB@@BB@@BBD@@@B@@@B@BABBD@B@B@@@B@BA@@B@B@@@BBBBBBB@@@D@@@@BB@@BB@@@D@B@BBB@B@BB@@B@@B@B@@@B@@@B@@@BB@@@@B@B@B@B@@BB@BB@@@BBB@@BDBB@DBB@@BBD@@@BB@BB@@@@@B@B@@@B@@ABC@ABABABAB@B@@AB@@ABABA@@BA@@@A@A@@@@BA@@BB@@@BB@@@BBBB@BBDBBDBB@B@@B@B@H@F@FBB@DAD@B@DAD@@AB@BBBBB@BBBB@BB@@B@F@@@@@B@@BB@@@BB@@B@@A@@B@@D@@BB@B@@BB@@@B@B@BB@@B@@@@@BBB@BB@@B@@@@BB@@@@@B@@@B@B@@B@@B@@@@@BB@@B@@@@BAB@@@B@B@@BB@BB@@B@@B@@B@@B@@@B@B@@@@@B@@@B@@@@@@@B@@@@@B@B@@@BBB@B@B@BB@@@@B@@@BB@@@@B@@@@@BAB@@@B@B@@@@AB@@ABA@@B@BABA@@B@@@@AB@@@@AB@@@@AB@@@@@B@@@@@@@BB@@@B@B@@@BB@@BB@@BB@BB@@B@@B@@BD@@B@B@@@@B@@@@@B@B@@BB@B@B@@@B@@@@BB@B@@BB@@@BB@BB@@B@BB@@BBB@@@@@BB@@B@@@B@@@@A@@B@@AB@@@B@BA@@@@B@B@B@BBB@@@@@B@@BB@BB@@B@@@B@@@B@@@B@B@@BB@B@B@BBB@@B@@B@@BB@@@B@B@@BBB@@@@B@@@@@BAB@D@B@@@B@B@@@B@@@B@@@BB@@DBBBD@B@@@BBB@BBB@B@@B@@B@@@@@D@@@B@@@@@B@@@B@D@B@B@@B@@@@@BA@@BA@@B@@BB@B@@@B@BB@@BD@@BB@@@B@BBB@B@@@BB@@BB@@@B@@BB@BB@@@BB@@AB@@@B@@AB@@@@@@@@@BB@@BB@B@B@@@B@@@B@B@B@B@B@@@B@B@@BDBB@B@@@B@@@B@@@B@DBBBB@B@B@@BB@@@B@@@D@@@D@@@B@BAB@@@B@B@B@@@B@B@BA@@BA@@BAB@DABABADAFA@@D@B@BDDD@@BB@@BA@@@@B@D@@@BBB@@@B@@@B@B@@BB@B@@@B@@@B@@@B@B@@@@@B@BBD@B@@@@@B@@@B@BBB@@AB@B@@@B@@@@@B@@A@@@@@@B@BBB@B@@@@@B@D@@@B@@@D@B@B@@@@@@@B@@@@@BB@@B@@@B@B@B@@@@@AB@B@@@B@B@B@BB@@B@@@BB@@@@@@BB@@BB@@@B@@B@@BA@@@@B@@@BB@@B@@BB@@@B@DBB@B@@@B@B@@BB@@B@@B@@B@@B@B@@@B@BB@@@@@@@B@@@@BB@@@@B@BBB@@@B@@@B@@@@@B@B@@@B@@@@BB@@@B@B@@BD@@@B@B@BB@@@BB@@B@BB@BB@BB@@BB@@@B@BB@@B@@@BB@@@@B@@@@BB@@@B@@@BAB@@A@@B@@@B@@ABBB@@@B@@@B@B@@@B@BB@@DB@BB@@BB@@@@B@@@@B@@@BB@@B@@BB@B@@@BBB@BBB@BA@@B@B@D@DABBB@B@B@B@@@B@D@B@B@BB@@BB@@@B@@@@@B@@BBB@@@BBB@BB@@B@@@B@BBB@B@B@B@B@BBB@B@@@B@@@@@@@B@@A@@B@@A@@@A@@@AB@@@@@@@B@@@B@@AB@@@B@@AB@@AB@@@@AB@@@@@BAB@B@@@B@@A@@@@@@@@@AB@@A@@@@@@@@@@BA@@@@@@@@@A@@@@@A@@@AB@@A@@@@@@@A@@@@B@@@@A@@@@@@AAB@@A@@@A@@@@A@@A@@@@@@@A@@@AA@@AB@@@@@@AB@@@@A@@A@@AA@@@@@@A@@@A@@@@@A@@@@@@A@@A@@@@@@@A@@@A@@B@@@B@@@B@@@B@@@@@BA@@B@@AB@@@B@@@BBB@B@@@@@B@B@@@BA@@BA@@BABCB@B@B@B@BAB@B@@BB@@@@BB@@B@@@@B@@@B@@@B@@@B@@A@@B@BA@@B@BA@@@@AAAC@@A@@A@@AA@@@A@@@AB@@A@@@@@AA@@@@A@AB@B@@@BA@@@@@@BA@@@ABA@@BA@@@@@A@@@A@@A@@@@AA@AA@@@A@@@AAA@@BC@@AAA@@A@@A@@A@@@@@@@A@@ABA@A@A@A@AA@@@@@A@@@@@@B@B@@@BA@@B@@A@@@@BA@@@@@@AA@AA@@@@A@@@A@A@A@A@@A@@AA@@AA@@ACA@@BABA@@BA@A@@AA@@AA@A@@@A@@@@A@A@AAA@A@@@AAA@@@CAAACA@@AA@AA@@@@AA@CAAAA@A@@@A@@@@@A@AA@@@AA@@@@AA@A@A@@AAAAA@@@@AAA@@@A@@A@@AA@@@A@@@A@@@AAA@@@@@@@@AA@@@@@@@@BA@@@C@E@A@@@@@@@@A@@@@A@@@@A@@@@A@@A@@@@@@AA@@@A@@@@@A@@@@@AA@@@@A@@@@@@@A@@@@@A@@@@@AB@@@@AB@@@@AB@@@@@@A@@B@@@AA@@@A@@@A@@@A@@AA@@@@@A@@@@AA@@@@@A@@A@@@@@@AA@@@A@@@@AA@@@@@@@A@@@@AA@@A@AAC@CA@AAC@A@@@@AA@@@@@A@@A@AA@@AA@@A@@@@@AA@@A@@@@@A@@@A@@@A@@@A@A@@@@AA@A@@@A@@AA@@@@@@@A@@A@@A@@@@@A@@@@@A@@@@A@@@@A@@A@@@@@A@@@@AA@@@@@A@@@@@@@@AA@@A@@@@@A@AA@@A@@@CA@@CBA@A@@@A@@@A@@@A@@@A@@@@@A@@@@@A@@BA@@@A@@@A@@@@@A@@@@@@B@@@@A@A@@BA@A@@BA@@@A@@@A@@BA@@@@@@@A@@BA@@@@@@@@@A@@@AA@@@@A@@@@@@@A@@@A@A@@@@@A@@@@@AA@@A@@@@@A@@@@A@@A@@@@@A@@@@@A@@@@AA@@@A@@@@@@@A@@@@@@AA@@@@A@@@@@@@AA@@@@@@@@@AA@@A@@@AA@@@@A@@@@@@@@A@@@@@@@@@AA@@@@@@@A@@AA@@@@@A@@@AA@@A@@A@@A@@@@@A@@@@@@@A@@@A@@@@@@@@BA@@@AB@@@@A@@@@@@@A@@@@@@@AA@@@BA@@@@@A@@@A@@@@@A@@@@@A@@@@@@A@@@@A@@A@@@@@@@AA@@@@@@A@@@@A@@@@AA@@@@@@@@@@@@A@@@@@@@A@@@@@@@@@@A@@@@@AA@@A@@@@@A@@@@A@@@@@@@AA@@@@@AA@@@@AA@@@@A@@@@AA@@@@@@A@@@@@@@@@@@@@AB@@@@@@@BA@@@@@@@@@A@@@@@@@A@@@@B@@@@@@@B@@AB@@@@@B@@@@@@@@AB@@@@@@@@AB@@@@@B@@A@@B@@@@@@@B@@@@@BA@@@@B@@@B@@@B@@@B@@@B@@@@@@A@@B@@@@@@A@@B@@A@@@@@@BA@@@@@@@A@@@@@@@A@@@@@@@@@A@@B@@@@@BA@@@@B@@@B@@@@@B@@@@@@@B@@@@@BA@@@@B@@@@@@@B@@@B@@@B@@@@@@@@@@@@A@@@@@@BA@@@@@@@@@@B@@@@A@@B@@AB@@@B@@@@A@@B@@@BA@@B@@@@@@@B@@@@@@@@@B@@@@@@@@A@@@@@A@@B@@@@@@A@@B@@@@@B@@AB@@@@@BA@@B@@@BA@@@@@@B@@@@A@@@@@A@@@@@@B@@@@@@@@@BA@@@@B@@AB@@@BA@@B@@@@@BA@@@@@@@AB@@@@@@@B@@A@@B@@@@A@A@@BA@@BABABCBA@@BABA@@B@@A@CBA@A@@@@B@@@@@@@B@@@@@B@@@@@B@@@B@@BB@@@@@B@@@B@B@@@BBB@@@@@B@@@@@B@B@@BB@@@B@@@B@@@@@B@@@@@BB@@B@@@B@@B@@B@@@@@B@@@@A@@B@@@@@@A@@@@BA@@@@@@@A@@@@@@BA@@BA@@@@@@B@@A@@@@@A@@B@@@@A@@@@@@@AB@@@@@@@B@@@@@@A@@@@A@@@@A@@A@@@@@@AA@@@@@@A@@@@@@@@@@B@@@B@@AB@@@B@@@B@@@@@B@@@B@@@B@@@@@BB@@@@BB@@BB@@B@@@BAB@BAB@@@B@BC@@B@@@@@@@BA@@B@@@@@B@@@D@@AB@@@@ABCB@BA@@B@@@@A@@@A@@@A@@@@@A@@@@A@@@@AA@@@@@@A@@@@@A@@@@@@@AA@@@@AAA@A@@@A@@@@A@@@@@A@@@@@@@A@@A@@@@@@A@@A@@@@A@@@@@@@A@@@@@@@A@@A@@@@@@AA@@@@@@@@@@A@@@@@@@A@@@@@@@AA@@A@@A@@A@@@@@@AA@@@@@@@@@A@@A@@@@A@@@@@@@@@@@@@@@@A@@@@@@@A@@@@@@@A@@@@@@A@@A@@@@A@@@@@@A@@@@@@@A@@@@@A@@@@@@AA@@@@@AA@@@@A@@@@@@A@@@@@AA@@@@@@@@B@@@@@BA@@@@B@@@@@B@@@@A@@@@@A@@@@@@@@B@@AB@@@B@@A@@B@@@@@@A@@@@@@@@@AB@@@@@@A@@@@@@BAB@@@B@@@@A@A@@@@B@@A@@B@@@@@AA@@@@@A@@@@@A@@@@@AA@@@@A@@@@@@@A@@A@@@@A@@AAA@AAA@AAA@A@A@@@@@A@AA@@A@A@@AA@AA@@@AA@@@@@A@@@@@@A@@A@@AA@AAAA@@@AA@@A@@@A@@B@@AB@@A@A@@@A@@@A@@@@@@@@AA@@@@@ACA@C@@@A@@@@@@@@@@@@@A@@@@@A@@A@@@@@A@@@@@A@C@A@A@C@AAA@@@A@@BA@@@@@A@A@@@@A@@@@@AA@@@@@@@@@@@A@@@A@@@AA@@@@@@A@@AA@A@@@@@@@A@@@A@@@A@@@@AA@@@@@AA@@@@@@AA@AC@AACA@@@@@@BA@@@@@A@@@A@A@A@A@A@@@A@@@A@@@@@@@@AA@@A@@AA@AAA@@@A@A@A@A@AAA@AACAA@@@@@ABA@ABCB@@A@@@AA@@A@@@@A@@A@@@AA@@A@@@@@A@@@@@AA@@@@@@@@AA@@A@@@A@AAC@A@@@@AA@@@A@C@C@A@@@A@A@AA@@@@@@AB@@AB@BA@@B@BA@@BA@@@ABC@AB@@@BA@@@A@@@@@A@@@A@AA@@A@A@@@AA@@A@A@A@AAA@A@A@@@A@@@@B@B@B@@@BBB@@ADBB@B@BA@@@AB@@A@A@A@@@CB@@@B@@@BB@BB@@@B@@AB@@@B@B@@@BB@B@@@@B@B@@@B@@@D@@@BBBB@BB@@@BABAB@BAB@BC@@B@@@@BBB@B@@@@@@BB@@BBB@B@@@BC@@BABAB@@C@@@A@A@@@A@EBCBA@A@ABCBABCBABA@A@A@@@@@@B@@A@@@@@A@@@@B@@A@@@@@A@@BA@@@A@@@@@@@A@@B@@A@@@@@@@@@A@@@@@@@@B@@@@@@A@@@BB@@@@@@@B@@@@@@@BB@@@@@@B@@@@@@A@@B@@@@@@@BA@@@@B@@@@@B@@@@@B@@@@@@AB@@@@@@@B@@A@@@@@A@@B@@A@@@@BA@@@@@@@AB@@@@@B@@@@@B@@A@@B@@@@@B@@@@@B@@@@@B@@A@@@@B@@@@@B@@@@@@@BA@@@@B@@@@@@@B@@A@@@@@@@@@A@@@@@A@@@AA@@@@A@@AA@@@AA@@A@@@@AA@@@@@@@@AA@@@@@@@AA@@@@@@AA@@@@@@@@@@A@@@@@@@A@@@@@A@@@A@AA@@@@A@@AA@@@@@A@@A@@A@@@A@@@A@@@@@A@@AA@@@@@@@A@@@@@@@AA@@@@A@@A@@A@@@@@A@@AA@@@@@AA@@@@A@@@@@A@@@@AA@@@@@A@@@A@@@A@@A@@A@@@@@A@@@@AA@@@@@A@@@@@@@A@@@@@@@A@@B@@A@@@@@@@@@@@@@A@@@@@@@AC@AA@CAA@A@C@A@C@A@@@A@@@C@C@@@A@AAA@AAA@A@ABAAA@AAAA@@@CAAAA@@@A@@AA@@@@A@A@@AAAAAAA@@@@@A@A@@@A@@@AA@A@AAABAAA@@A@@ACA@@A@@@A@A@@@@@AAA@A@C@AA@@A@A@A@C@@@AA@@@A@@@@@@@@@AA@@@@@@A@@@@@A@@@@@@@@@AA@@@@@@@@@@A@@A@@@@@A@@@@@@@@BA@@@@@@@@@@@A@@@@@@@@@@@@@A@@@@@@@@@@@@@@@@AA@@@A@AB@BAB@DAD@D@B@DBB@BBBA@@BABABADAB@@@AA@@A@A@C@A@CAC@AAA@A@CAA@@@@AAA@@@AC@A@A@@@AB@@A@A@AA@@A@ABA@A@@AA@A@@AC@A@@@A@A@AA@@AA@@A@@@A@E@A@ABCBABAB@@ADABAB@BABABAB@BAB@B@BB@@BA@ABED@B@@@BB@DB@BBB@BBBA@BB@B@DB@@BB@@@@BA@ABABA@@BC@ABCBABA@C@A@ABA@A@A@@@AAA@AA@@AA@A@@@A@ABA@@@A@@@AA@@A@@@A@A@@@A@A@A@AAAA@AA@@AAB@B@@AB@BABA@A@A@A@A@A@AAC@@@A@A@@A@C@@@A@A@A@AAA@@AAAA@AA@AA@A@A@@@A@@A@@@@A@AAA@A@A@A@C@@AA@AA@AAAAA@@AA@AA@AAA@AAA@A@A@A@C@C@A@C@A@AB@AA@C@C@C@A@A@A@AA@@ACAA@AA@AAA@AAA@AA@@@@@AAA@@@AAAB@@ABA@@@A@A@ABA@@@ABA@@@@BA@@A@@AA@AAAA@@AA@@AA@A@@@ABA@A@@@@@A@A@@@A@A@@BA@A@@BAB@B@BAB@@A@@B@BAB@B@@@B@@@BA@A@A@AB@@@BAB@@@B@@BB@B@BBB@BA@@BA@@BA@AB@D@@@BABABA@@@AA@A@AA@@AAAA@@B@@A@@@A@ABABA@ABAB@@A@@@A@@@AB@@AD@BAB@@ADA@A@AA@@AA@AAAAAAAAA@AAAA@A@@@A@A@@@A@ABAB@BAFAB@DADC@@BA@@A@@@AAAA@@@A@A@A@ABA@A@A@@@AD@BABA@A@AAAAC@AAAAA@A@@@A@@@A@@BA@@@@D@@B@BBBBDBBBBB@D@BB@@DAB@B@@@B@@A@@@A@@@@BA@@@@B@@AB@B@B@BBB@@@@@B@@@B@@@B@@@BA@@@@DAB@BAB@B@BB@@BA@@BA@@AA@A@@@A@A@@@A@@A@@AAA@@@A@@@A@@@A@@@A@@@A@@A@@@BA@@@@@A@A@A@@@A@@@A@@@@A@@@A@C@A@A@@@A@AAA@A@@AA@@@AA@BA@A@@@A@A@@@AA@@@@AA@A@@@@AA@@A@A@AB@@A@A@@@@@A@@A@@A@@AA@@@AA@@AA@@@@A@@AA@A@A@@@@@AA@@@@A@@A@@A@A@A@@@A@@@A@@@A@A@A@A@@@C@@@A@A@A@A@AAA@A@AA@@A@AAA@@@AAA@A@C@A@CAC@AAC@A@AA@@A@@A@@@A@@@A@A@A@@@ABADCBC@C@EAEDEBGBA@C@ADCBEDCDC@CBABCBCDEBCBABC@AAAECCAGACAA@C@AAAAAA@@A@E@GAE@G@C@C@A@@AAAAC@A@A@C@CBCBEBA@CBA@E@C@AAACCCCEAEAGAC@AAAAA@C@E@CBC@ABC@ABABADEBABCDA@@@A@A@AAAAAAACAC@A@@@A@@@A@CBCBABCBA@AD@DADAF@BAB@BA@A@A@C@C@A@AACAECCAEAA@C@C@@BEBC@@@A@@@AA@AAE@EAA@E@EAA@CBCBEBEDCDEBGDC@CAA@CCACAC@@@GBEDCBABAFCDABA@ABA@A@A@@@@AAA@AA@CAACACA@ACAAACAC@A@C@AAC@CAAA@AAAAACAAAE@C@E@EAC@A@C@ABC@EBEBC@C@C@C@A@E@CACACAECACACAC@A@EACAACCA@@AA@AAAA@@@A@@BA@CBA@CAEACAEACAA@CAAAAA@C@A@A@ABA@CBC@EBG@E@C@EAAA@AA@BA@A@A@A@CBA@ABABCDCDCDAHEHCHCHCDA@@BABC@CAAACEAGCGAE@E@E@EDEFCBEDEBC@GAICGEECGGKOIDUCIGA@C@EBCBGDCBABAFADBD@D@BBBDDDBDDBB@B@BA@ABADAD@DADAD@B@BA@@BC@ABA@A@@AA@A@C@C@C@E@A@A@@@A@GBA@@BA@ABCB@@A@A@A@@@@@A@@@@@@@@@A@@@@@@B@@@BBB@B@@@@@B@@@@@@@B@@BBBB@@@@B@@@@BB@@@@BA@@BA@@B@@@B@@@@@B@@@@A@@@A@A@@@@@A@@B@@@B@@@D@@@@AB@@@@A@AB@@A@@@A@@@@@A@@@AA@@@@AB@@AB@B@B@B@@A@@BABAB@@AB@@@B@@@@@BBB@@B@BB@@@@@@@B@@@B@@@@@B@@@@BB@@B@@@B@@B@@ABAD@@@B@B@@A@@@@B@@A@@BA@@B@@@B@@@@@B@@@@@B@@@@@BBB@@BB@@@B@@@B@@@@@B@@@@@B@@@@@@@B@@BB@@@B@@B@@@@B@@B@@@@@@@@@@B@@@@@B@BAB@@@B@@@B@@@@BB@@@B@@BBB@@@@B@@A@@BA@A@@@@BA@@@@B@@AB@B@@A@@B@@A@@B@@@@AB@B@@AB@@@@@BA@@@@@A@@@A@@@A@@@AA@@A@@BA@@@A@A@A@@@@@A@A@A@A@@@A@@@AAA@@@AB@@@@@@@B@@@@@B@@@BB@@@@@AB@@@@@@@@B@@@@B@@B@@B@B@@@B@@A@@BB@@@@@@B@@@@@BCBABCB@BAB@@@@@B@@@@ABA@@@A@@BA@AB@@@@A@@@@B@@@@@@@BA@@@@B@@@@@@@BB@@@A@BBA@@@@@ABC@A@@@CB@@A@@@ABAB@@A@@@@@ABAB@@@@@B@@B@@B@@@@AB@BA@@B@@@@@@@B@B@B@B@@BB@@@BB@@@@B@@@B@@@@B@B@D@B@B@@@B@BB@@B@@BB@@BBB@@@D@B@@@D@@@BB@@@@BB@@@@@@B@@@@@@@BA@@@C@ABA@A@A@A@ABA@A@A@A@@@A@A@@@A@@BCB@@AB@@A@@BA@@BA@AB@@A@@B@@@@@B@@@@@@A@@BA@AAA@@B@@@@@@@B@@@@AB@@A@@BA@@@@@B@BB@@B@@B@@@@AB@@@BAB@@@BA@@B@B@@AB@@@B@@BB@B@@@@AB@@A@@@@BA@@@A@A@@@@@AB@@AB@@AB@@@@AB@@ABA@A@A@@BA@@@AB@@@BA@@B@BA@@B@B@@BB@@BD@BBB@BB@@BA@@B@@AB@@CBAB@@AB@BA@AB@B@@A@A@@B@@@@@@@BA@@BA@@@@B@@@B@B@BA@@B@@@B@@A@@BA@@B@@@B@B@@@B@@@B@B@BB@@@@BB@@BB@@@@B@@@BA@@BAB@@@B@@@@B@@BB@@@BB@@@B@BBB@@@B@BA@@B@B@BB@@BB@@BD@BB@@BBB@@BB@@BB@@@BB@@@BB@@BB@@BB@B@@BB@@B@@@B@@@@@@BB@@@BBB@BBBA@@B@@@@ABA@A@CBA@A@C@A@@BA@@@@@@@@BAB@@@B@BA@@@@BA@@BA@@BA@@@@B@@@B@@@B@B@@AB@@@BA@@BA@@@@B@@@@BB@@BBB@@@BB@@BB@@@B@@AB@@AB@@A@A@A@@@AB@@@B@@@B@@@B@@@@AB@@@@@B@@@B@B@@B@@B@@@BA@@@ABA@@@AB@@@AA@A@A@AAA@@BA@A@A@A@@@A@@@A@@@A@A@AA@@A@@@@B@@AB@@A@A@AB@@A@@B@@A@@B@@A@@@AB@@A@@BA@@B@@AB@@@@ABA@@BA@@BA@ABAB@@A@@BA@@BA@@B@@AB@@A@@@AAA@A@AAA@AA@@ABA@A@A@@B@@A@CAA@A@A@@A@@@AA@@@@@A@@AA@A@A@C@A@@@C@ABA@A@@@A@@@A@AA@@A@@@A@A@@@@AA@@AA@@AAA@@A@A@@AA@@@@A@@A@@A@@A@AAA@CAA@@AA@@@@@A@@B@@AB@@A@@@A@@@A@A@@@A@A@@@A@AAA@AB@@AAA@@@A@AA@@AA@A@@AA@AAA@@@@A@@@A@@@AB@@A@@@@@A@@@@@A@@@A@@@A@A@@@@@A@A@@BC@@@A@@@@@A@@@@AAAA@@AA@AA@@A@@@@@@@AB@@@@@@A@@@A@@@@@A@@@@BA@@BAB@B@@A@@B@@@@AB@@@@@B@@B@@B@@B@@B@@@B@@@B@@@B@B@@@BBB@@BDBBBBBB@B@BB@@B@B@@BB@@@B@@@D@BA@@B@BBBBDDDBFFD@B@B@BB@@B@@BB@@@B@B@@@B@B@B@@@BAB@@@BA@@BAB@B@B@B@B@@@BAB@@@BB@@BBBB@@BB@@@@BBBBDBB@@@@B@@B@@@@@@@B@@@@@@@@@@AB@@A@@@@BA@@@A@@B@@@@@@@BA@@@@B@@@@@@B@@@@@@BB@@@@@@@@@@@@@A@@B@@@@@BA@@@@BA@@B@@@B@@B@@BB@@BB@@BB@@@B@@B@@@@B@@B@@B@@@@@@@BB@@@@B@@@@BB@@A@B@@B@@@@@@@B@@@B@BB@@@B@@@@@@@BA@@@@B@@A@@@@@@@A@@@@@@B@@A@@@A@A@@@AB@@@B@@@@@@@@@@AA@@@@@@AB@@@@A@@@@@@@@@@@@@@B@@@@@@@@@@A@@@@@@@@@@B@@@@@B@@@@@@A@@BA@@@@@@@@@@@AA@@@@@@@@@@A@@@A@@@@@@@A@@@@@@@A@@@@@@@@@A@@@@@@@@@@B@@A@@@@A@@A@@@@@@@A@@@@B@@A@@@@@@@@@@@@@@@@@A@@@@BA@@@@@A@@@@@A@@@@@B@@@@B@@@@@@@B@@@@@@AB@@@@@@@@@@@@@@@@B@@@@@@B@@@@A@@@@@@@@@AB@@@@@@@@@@@B@@@@BA@@@@@@@@@@@@@@@B@@@@@@@@B@@@@@@@@@@B@@@@A@@@@@@@@@@@@@@@@B@@@@@@@@B@@@@@@@A@@B@@@@@@@@@@BB@@@@@@@@A@@@@B@@@@A@@@@@@B@@@@@@@@@@AB@@@@A@@@@@@@@@@B@@@@@@@@@B@@B@@@@@@@@@@@@B@@@@@@@B@@@@A@@@@B@@B@@@@@@B@@@@@@@@@B@@@@@B@@@@@BA@@@@@@B@@A@@@@@@B@@@B@@@@@@A@@B@@A@@@@@@@@@AB@@@@@B@@A@@@ABA@A@@@A@A@@BA@@@@@A@@B@@@@@@@B@@AB@@@@@@@BA@@@@B@@@@@@@@AB@@@B@@@@@B@@@@@@@B@@A@@@@B@B@@@@@@@@AB@@@@@@@@@@@@@@@BA@@@@B@@@@@@@@@B@@@@@B@@A@@@@@@B@@@@@B@@@@AB@@@@@@@@@BA@@@@@@@@@@@@@@BA@@@@@@@@B@@@@A@@B@@@@@@@BB@@@@@@B@@@@AB@@@B@@@B@@@B@@@B@@@@@B@@B@A@@@@BAB@@@@@@@@@@@B@@B@@@BB@@@@@@@@@@@@@BB@@@@@A@@@@@@@A@@@@@@@CD@@@@@@@@BB@@@@@@@@A@@@@@@@@@@@@@@B@@@@@BB@@B@@@@@@A@@@@@@B@@A@@@@@@B@@B@@@@@@@AB@@@@@B@@@@@B@@@@@B@@@@@@@@B@@@@B@@@@@B@@@@@@@B@@@@@@@@@@@@A@@@@B@@@@@@@@B@@B@@@@@@B@@@@@@B@@B@@@B@@@@@B@@@@B@@B@@@@@@@@@@BB@@B@@@ABB@@@@@@@@@@@@A@@@@@@@A@@B@@@@@B@@@@@BB@@@@@@@@@@@@B@@A@@@@@@@@@@B@@@@@@@@@@@@@@@@@B@@@@@@@@@@B@@BB@@@@@@@@@@@AB@@@@B@@B@@@@@@B@@@@@@B@@B@@B@@@@A@@@@@@BB@@@@@@@AB@@A@@@@@AB@@@@@@@@@B@@B@@B@@@@@@@@@@@@@@@B@@A@@@@@AB@@AB@@@@@B@@@@@B@@@@@@BB@@@@@@@@@@@@@BAA@@@B@@@@@@@@@@@@@@@@A@@@@B@@@@@@B@@@@@@B@@@@@@@@@@@@@@@@@B@@@@@@@@@@@B@@@@@@@@@@B@@@@@@@@B@@@@@@@@A@@B@@@@@B@@@@@B@@@@@@B@@@@@@B@@B@@@@B@@@@@@@@@B@B@@@@@@BBB@@@BB@@@@B@@@@@@BB@@@@@@B@@@@@@@@BB@@@@@@@@@B@@@@@B@@@@@@@@@B@B@@@BA@@@@@@@@@@B@@@@@@BB@@@@@B@@B@@@@@@B@@@@@B@@B@@B@@@@@@@BA@@@@@@@@B@@@@@@@@@@@B@@@@@@A@@@@B@@@@@@@@@B@@@@@@@@@@@@@B@@@@@@@@@@@@@B@@@@@@@@@@@@@@@@@B@@@@@@@@@@@@@@@@@B@@@@@@@@@@@@@@@@@@B@@@@@@B@@@@@@@@@@B@@@@@@@@@@B@@@@@@@@@@@@@B@@@@@@A@@@BB@@@@@@@B@B@@@B@BBB@@FBB@B@B@B@@BB@B@@@B@@@@@BBB@@BB@@@D@BBB@B@@@B@@@B@@@B@DAB@@@DBB@B@BBBA@@@@F@F@@AJ@F@B@B@@@@@"],["@@B@@@B@B@BA@@B@@AB@@@BB@@@@B@@AB@B@B@B@BAB@BAB@@@@A@@@@B@@@@A@A@@@A@A@@@A@@@@BA@@@A@AAC@A@@B@BBBB@@B@@@BA@@B@@@@BB@@@@@B@@@B@@@@BB@@@@@@@@B@@B@@B@@@B@@@@@@B@@B@@B@@@BBB@@@BB@@B@@@B@@@B@@@@@B@@@@@BA@@@@@@B@@@@@B@@@B@@@B@@BB@@@B@@@D@@A@@BB@@B@@@B@BBD@@@@@@@B@@@B@@@@AB@@@B@@AB@@@@@@@B@@@@@@@@@B@@@@@@@@@BA@@@@@@@@B@@@@@B@@@B@B@B@@@BB@@@@B@@@@BB@@@B@@@B@B@BA@@B@B@@@@@@@B@@@@BB@@@@BB@@@@BB@@@@@B@@@@@B@@@@@B@@@@@@@B@@@@@B@@@B@@@B@@@B@B@B@B@B@B@B@B@@@@@@@BB@@@@B@@@B@@@B@@BB@B@@@BB@@B@@@BB@@B@@BB@@@BB@@@@@@@A@@@A@@@@@@@AB@@@@@B@@@@AB@@@@@B@@B@@D@D@@@@AB@D@BABAB@@@@AB@@@@A@@B@@AB@@AB@@@@AB@@@BA@@@@BA@@B@@@@@@@@@@@@AA@@@@@A@@@AA@@@@@@A@A@@A@@A@@@AA@@@@A@@A@@@@@@@@@A@@@A@@@AB@@A@@@A@@@@@@@A@@@@@@AA@@@@@@@A@A@@@@@A@@@@@@@A@@A@@@@@@@AA@@A@@@@A@@A@@A@@@@@@@A@@@@@@@A@@@@@@@A@@@A@@@A@@@@@@@A@@@@@@@@@AA@@@@A@@@@@A@@@@@A@@@@A@@AA@@A@@AA@@A@@A@@@@@@A@B@@A@@@@@A@@@AA@@A@@@A@@A@@A@@AA@@@@@AA@@A@@@A@@@@AA@A@@@A@@@A@@AA@A@@@AA@@A@@@A@@@AB@@A@@@A@@@@@@B@@@@@@@@A@@@@@@@AB@@@@A@@@@@@B@@AB@@@@@B@@@@@@A@@@@@@@@@A@@A@@A@A@@@@@@@A@@A@@@@A@@@@AA@@@A@@@AA@@A@A@@@@@A@@@A@@@@@A@@BA@A@@@@@@@A@@@@@@AA@@A@@A@@@@A@@@A@@@A@A@A@@AA@@@A@@@A@@@@A@@@@@@A@@A@@@@AA@@@@AA@@A@@@AAA@@@A@@AA@@@A@@AA@@@A@@@@@@AA@@@@@@A@A@@@@@AA@@AAA@@@@@AA@@@@@@@BA@@B@@@@AB@@@@AB@@A@@BABA@@@@BA@@@@@AB@@@@A@@@@@@@A@@@@@@@A@@@@@A@@@@@@@@BA@@@@B@@@@A@@@@B@@A@@@@@AB@@A@@@@@@B@@A@@@@@@@@@@B@@@@A@@@@@@@@BA@@@A@@@@@A@@@@B@@A@@@@B@@A@@@@@@B@@A@@@@@@@@@A@@@@B@@@@@@@@@@A@@B@@A@@@@@@B@@A@@@@B@@@@@@@BA@@BAB@@@@@@@BA@@@@B@@@@@B@@@@@@@@AB@@@@@BAB@@@B@@@@AB@@@@@@@@@@@@A@@@@@AA@@@@A@@@@@@@@@A@@A@@@A@@@AAA@@@A@@@@@AA@@@@@@@@A@@A@@@@AA@@@@@@AA@@@@@@@@@A@@@@@@@@@AA@@@@@@@@@AA@@@@@@@A@@@@A@@@@@@A@@@@@@@A@@@@@A@@@A@@A@@A@@@@@@@A@@@@@@AA@@@@@A@@@@A@@@@A@@A@@A@@A@@@@A@@@@@@@AB@@@@A@@@@@@@A@@@@@A@@@A@A@@@@@A@@@@AA@@@@@@A@@A@@@AAA@@A@@A@@@@AA@@@A@@@A@@AA@@@AA@@@A@@A@@@@@@@AB@@@DA@@B@@A@@@A@A@AB@@AB@@A@@B@@@B@B@@@@A@@@A@@@A@@@AB@@@B@@A@@@AB@@A@@B@@@@A@@@@@@@@@A@@@A@@@AA@@@@AA@@AA@@@@A@@A@A@@@A@@@@AA@@AA@@@AA@@@@A@AA@@@@A@@A@@@@A@@@@@A@@@AA@@A@@A@@@@A@@@A@A@A@A@@@A@AA@@A@@@@@AA@@A@@@A@@@A@@@@@A@@@A@@@@@@AAA@@@@@AA@AAA@@@@AA@@@A@@AA@@@@@A@@AB@@@@A@@A@@@@@AAAA@@@@@@A@@@@@AAA@@@@@AA@@@@@@A@A@@AA@@@A@@@@@@@A@@A@@A@@AA@@@@@@@@A@A@@@A@@@A@@B@@@@A@@@A@@BA@@@@@@@@@@@A@@@@@AB@@A@@@@A@@A@@@AB@@A@@@@AAA@@@@A@@@@@A@@@@@@@A@@@A@@A@@AB@@@@A@@@@@@@AA@@@@@AA@A@@@@A@@@@@@A@@@@A@@@@@@@@@@@@@@AA@A@@@A@@@@@@AA@@@@@@AA@@@A@@@A@A@@@A@@@@AA@@@@@@@@@A@A@A@@@@AA@@A@@@@@A@@@@@@@A@@A@@@@A@@@@@@@@A@A@@AA@@@@@C@@@A@A@@AA@AA@@@A@@AA@@@A@@@@BA@AB@@@@A@@@@@A@@@@@A@@@@@AB@@@@@@A@@@@@AAA@A@A@@@@@@@A@@@@@A@@A@@@@AA@@A@@AA@@A@@AA@AAA@@AA@@@@@@@@A@A@AA@@@@A@@A@@A@AAA@@A@@@@A@@@@@AB@@AB@@@@@@A@AA@@A@@@@B@@@@@@@BA@@@@@@@A@@@@B@@@BA@@@@B@@@@@BAB@@@@@@A@@@A@A@@@@@@BA@@@@@A@@@@@@@@@@@A@@@@@A@@A@@@@@A@A@@@A@@@@@A@A@@@A@@@@@@@@@A@@@A@@@@@@@@@AB@@A@@@A@@@@@@@@@@@A@@@@@@@A@@@@@A@AAA@AA@@AACAAAC@@AA@@@@A@@A@@A@@A@@@@A@@A@@@@@A@@@@A@@A@@AA@@@AA@@AA@@@A@A@@AA@@@@AAA@A@AAC@AAA@AA@@A@@@@@A@@@AAA@@@A@A@A@@@AAAAA@@@A@@@A@C@A@A@@BA@C@E@A@A@A@@BAAA@A@A@A@@AA@@@A@@@A@@@AAA@AAAAA@@@A@AA@@A@@@A@A@@B@@A@@@A@@BA@@@@@@BA@@@@@AB@@A@A@A@A@CA@@@AA@AA@ACAA@@@@A@A@@@A@@@A@AA@A@A@A@A@A@A@AA@@@@A@@AA@@@@@A@@AA@@@AA@@AA@@A@A@A@ABA@@@A@A@ABA@CB@@@@@@@BA@@@@@@BA@A@CBCBA@AB@BAB@@BB@@@B@@A@@@@@@@A@@@@@A@@@A@@AA@@@A@@A@@A@AA@@@@AAC@A@AAC@A@A@C@A@A@A@AB@@A@@@A@@@A@@B@@@@AB@@@@@B@@AB@@@B@B@B@B@B@B@B@@@@AB@@A@@@A@@B@@@@AB@@@@A@@BB@@@@B@@@B@B@B@@@BA@@@@B@@@@@@@@@@@B@@@BA@@B@@@B@@@BA@@@@BB@@B@@@B@B@B@BA@BB@B@BBB@@@B@@A@@B@@@@AB@@A@A@@B@@A@@BA@@@AB@@@@ABA@@@A@@@@B@@@BB@@@@B@@@B@@@@@B@@B@@B@B@@@BB@@B@B@@@@@B@@@@@B@@@@@B@@@B@@@B@B@@AB@@A@AB@@@B@B@@@B@@@B@@AB@@@B@B@@@@@@A@@BA@@@A@@@A@@@@@A@@@@@ABA@A@C@@@A@@@A@@@A@@BC@A@A@ABA@A@AB@@CB@@A@A@A@@BA@@BB@@@@B@B@@@@ABB@@B@@@B@@@@@B@B@BBB@BB@ABA@AB@@AB@@@@BB@B@BB@@BB@B@BBBB@@BB@B@B@@@B@@@B@@BB@@@BB@@B@@@@@@@B@BB@@B@@BB@B@@@BAB@B@B@B@@@BA@@@@B@@A@@B@@A@@B@BBB@@@B@BAB@B@@@BA@@@@B@@@@@B@@@@@B@@@B@@B@@B@@BB@@@@BB@B@@@BB@@B@B@@@B@BAB@B@B@BBDA@@B@B@B@@DB@BB@BB@BA@@BA@@@ABA@A@@@AB@B@B@@A@AB@BAB@@A@@BA@@@@@AB@@@@A@@@@@ABA@@@A@@@@B@@BB@@@BB@@B@@@@@BA@@BA@@@AB@@@@ABA@A@@B@@@@@BB@@B@@@BB@@B@@@BA@@BA@@BB@@@BB@@B@AB@B@B@@@B@@@B@@@@@@@B@@@B@@@@@@@@ABA@@B@BABCBABAB@BABABA@AB@BA@A@A@A@AAA@A@AA@@A@@A@@ABA@@BABAB@@ABA@@BAA@@A@A@A@@@A@AB@@A@@@@B@@AB@B@BA@@BABABB@@@@BB@@BB@@BB@@B@@BB@@B@B@B@BA@@B@@AB@@BB@B@B@B@BAB@B@B@B@B@@@BB@@B@BBB@D@BBDAD@B@@@BB@@BB@B@@@BA@AB@@ABAB@@A@@@@@B@@B@@BB@@BDB@BB@@BBB@B@BBB@B@B@@@@BA@ABABABA@AB@BAB@BAB@@A@A@AB@@A@AB@@AB@@A@@B@@@B@BB@@BAB@@A@@@AB@@@B@BA@@@@@@@A@A@A@A@C@A@ABA@A@@BA@@@A@AB@@AB@B@B@B@@ABA@@BA@AB@@ABA@ABA@AB@BA@@DA@@BA@@B@@A@@BA@@@AB@@@B@@@B@B@B@@AB@@CBA@A@AB@@ABABA@A@@@A@@AA@A@A@A@A@AB@@@@AB@@@B@@@@BB@@@B@B@@@@@B@BAB@B@@@@@@A@@BA@ABAB@BA@@@AB@@@@BBB@@B@@@BA@BB@@@B@@A@@@ABA@@@@@AB@@A@@BA@@@@B@@@@@B@@@B@@@B@@@B@@A@@B@@@@@B@@B@@@@@B@B@@@BB@@B@B@@@@@BB@@@@BB@@B@BB@@@@BBB@B@@BBBBB@BBBBD@@BB@BB@B@BBB@BAB@B@BBB@@B@@@B@@@B@@B@@@@BB@@B@@@BB@@@@@@@BBB@DBBBB@DBB@@@@@B@B@BA@@@@B@DBBB@@BBBBBB@@@@B@@@B@B@BAB@@B@@B@@B@B@@BBB@BB@B@@B@@@BB@@B@@B@@@@@@B@@@@BB@@@B@BBD@BBB@DBB@D@B@@@BBBBB@BB@B@@@@@@@@@B@@A@@B@@@B@@@B@@BBBBDBBBD@@BB@@@B@@AB@@@B@B@B@BA@@B@@@BB@@BB@@B@B@@@@@@B@@@BBBB@BBBB@@B@@BB@@@BB@@@@@@@B@@@@@@@B@@A@BB@@@@BB@@B@@@B@BB@@B@@B@@@BB@@@@B@@@@@B@@B@@@@BBB@@@@@@@B@@@@@B@B@@BB@@B@@BBB@@@@@BB@BB@@B@B@B@B@B@@AB@B@@@@AB@@BB@B@B@@@B@D@@B@@@@ED@D@@@@@@BB@@@@B@B@@@BA@@@@B@@A@@@@@@B@@@BBB@@BBB@@@@@@BAB@BA@@BA@@BAD@B@@A@@@@@A@ABA@@BA@@DA@@BABA@ABABA@A@@BA@@B@@@@A@@@@@A@A@A@@@ABABA@@B@@@B@@A@@@@@A@@@AB@@@@A@@@@@@@AA@@A@@@A@A@@BA@@@A@@@@B@@@@@@A@@@@AA@@B@A@@A@@@A@@@@A@@@@@A@@@A@C@A@CAA@E@GAEA@@AA@AAA@ABC@ABAB@D@BBBAB@@@D@D@D@F@B@B@@@B@D@BBBAD@B@D@D@@@B@B@D@D@DBB@D@F@BBBBB@B@@@B@B@B@B@B@B@D@B@@@B@@@@@@@@@@AB@BABAB@@@B@BBB@@@B@@@BA@@B@B@@@@@BA@@@@B@@@BABBB@B@@@BB@@@BB@@@@B@@@@B@@@@@B@@@B@@@@@B@@@B@@@B@B@BA@@B@D@B@B@@@B@@@@@B@@@B@@@@@B@B@@@BA@@DABA@@BA@@@@@@BA@@@AB@@@BAB@B@B@BAB@@@B@DB@@@@BB@@B@@@B@B@@B@B@B@@@@@@@BB@@B@@@@B@BAB@B@B@B@"]],"encodeOffsets":[[[128361,42935]],[[129333,42671]]]}}],"UTF8Encoding":true});}));