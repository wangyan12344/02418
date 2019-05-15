(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('克山县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230229","properties":{"name":"克山县","cp":[125.874355,48.034342],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@B@FBF@DBFD@BBB@@BB@@B@B@B@BA@@@A@AB@BAB@D@B@BABAB@B@B@@AB@@A@@BA@@@@@@@@B@B@B@BBD@@@B@@@B@@@B@B@B@@@@@@@@BBB@@BB@@B@B@B@B@B@B@BAB@B@@AB@@AB@B@B@@@B@@@B@@BB@B@@@B@D@@AB@D@DAB@B@B@B@B@BB@BBB@@@@AB@@@B@@BBB@B@B@@@B@BA@@@@@A@@A@AAA@@A@@@AB@@AD@B@@AB@@@DA@@B@B@B@@@D@@@B@@BB@B@B@@UBE@I@E@E@C@E@C@A@C@E@C@C@C@A@C@@@A@ABEBEA@@@@@@A@@@@@@@A@@@@@AB@@@@@B@@AB@BA@@@ABCBEBCAB@BA@ABAB@@CBA@CB@@C@CAC@@@AA@@A@AA@@AA@@@AA@@A@A@@@ABA@AB@BADCDCLGBC@CBC@ABABG@C@@B@@A@@@EBEBG@A@AAA@@A@@ABC@A@CBA@@@C@@@@BA@C@ABA@C@@@ABA@A@A@A@ABA@A@C@@@@BGBE@CBC@CBGBCBA@CBCBC@E@CBA@@@AB@BABAJM@ABADEBC@@@@@A@@BA@@@@B@BA@@@@BA@@@@@@@@B@@@@@@A@@@A@A@@BA@A@@@@@A@@@A@@@@@A@@@@BA@@@@BABABA@@BC@@@@@A@@@@@@HAD@B@DAB@BA@@B@BA@@B@B@BAB@B@B@B@@@D@B@D@D@D@B@D@B@D@B@B@B@B@BA@@@@B@BA@@HAHAHCD@FAFAFABADADC@@BA@@F@B@BBF@F@F@@@BBB@@@B@B@B@B@T@F@H@@C@E@AAE@C@E@E@GACFCB@FAHAJCF@FAD@BAB@BAB@DAB@DCB@BAD@B@BB@@DBB@B@DAB@B@F@F@D@B@B@DAFEBA@@B@@@FAH@@@@@BADABABAB@BABAFABA@@B@B@B@@A@@@A@AB@@A@AAAA@AA@@@A@A@@BA@@@ABA@C@@@A@A@@BAB@@A@@@A@A@A@@@ABA@A@@@ABC@A@@@@CAA@A@A@@@@AAA@A@A@AB@@A@@BA@@@@BA@A@@@@@C@AB@@A@@@A@@BA@@@A@@BA@A@@@AAA@@@A@@BAB@@@BA@A@@@@@ABA@@@A@@BA@ABABABADCBAB@BABA@A@@@A@A@A@A@A@C@@@A@A@A@A@AAA@A@@@A@@@A@A@A@C@@BA@A@A@@@ABA@@@C@ABE@C@A@A@@@A@ABC@A@@@A@@BA@A@@A@AC@A@A@@@C@C@A@CAA@@@A@A@AB@@AB@B@@@BA@ADAB@B@@A@@@AB@@ABAB@B@B@D@D@D@D@BBB@D@D@B@B@DBF@F@D@DBD@B@B@D@B@D@DADA@ABA@@B@@A@@@@@@@AA@@@@A@A@C@A@A@@B@@@@A@@@A@@@A@@@ABAB@@@@A@A@@@A@@BA@A@@@@@A@@@@@C@AB@@A@A@AAA@AA@AAC@C@C@A@C@AAA@A@A@@@A@@@A@A@A@@AC@A@A@A@@@AA@@A@C@A@@@A@AAA@A@@@A@C@A@A@A@A@@@C@@@A@A@@@A@@@@@@C@C@A@@BA@A@A@A@@BA@@@A@A@A@@@ABA@A@A@ABC@CBA@A@A@ABA@A@@@A@@BC@A@A@A@@BA@A@@@A@AB@@A@A@A@@@A@@@ABAA@@AB@@A@A@@BC@@@C@@@@@A@@BA@C@@@A@@@@@@BA@@@A@A@ABA@A@@@A@@@A@A@@BA@C@A@A@@B@@@@A@A@@@C@A@ABA@A@@@C@A@A@A@@@AB@@A@A@@BC@A@C@CBA@A@CBC@A@A@A@@BA@@@@@A@@@ABA@@@A@A@@@A@AB@@@@A@@@A@@@A@@BA@A@A@@@CBC@A@A@ABC@A@A@ABC@A@@@@@@B@@@@A@@@@@@@@@C@A@@@A@@@A@A@@BA@A@A@@BA@@@A@@@A@@BA@@BA@AB@@C@AA@@@@A@A@@@A@@@ABA@A@@@A@@@A@A@@BA@@@@@C@A@ABA@@@A@@@A@A@@@@@@@@@A@@B@@A@A@@@@A@BA@ABA@C@ABC@A@A@A@AB@@@@A@A@A@A@@@A@@@A@AB@@@@CBE@A@EBA@A@@@CBEBG@@D@T@H@J@JBF@@C@ABA@EBC@A@ABGBA@CBC@EBEBC@A@A@@@ABA@C@ABC@A@@@CBEBC@@@@@ABA@@@C@E@C@@C@E@EAG@E@E@E@E@I@G@GAC@C@G@E@I@E@KAG@G@G@G@C@A@GAA@E@E@C@C@E@IAA@C@E@E@E@A@C@E@A@EAA@C@C@C@A@C@A@C@A@AAA@C@E@C@E@E@E@CAE@C@C@E@C@C@E@C@E@CAE@C@C@C@A@A@@@C@C@C@C@A@A@A@AAE@E@E@E@E@G@E@C@E@C@E@C@EAG@A@C@A@A@A@C@@@A@@@C@C@EAA@E@A@C@C@CAE@E@G@@@CAC@E@A@E@A@AAC@C@C@C@E@@DA@A@A@CAA@C@E@A@A@C@A@A@EAA@A@E@G@@@C@A@C@EAE@@@C@C@C@A@E@CA@DA@A@E@A@A@C@C@A@A@A@A@MAA@E@A@A@IAC@A@@@GAC@@@A@@@@@@@@@@@A@@@@@@@@A@@C@A@A@A@C@A@C@CAA@A@C@C@A@AAA@AAEAEAC@A@C@CAA@G@AA@@@BA@@@@B@@@B@@@B@@@B@@A@@B@B@@@B@B@@@@@B@@AB@@@BC@@B@B@@@B@@AB@BAF@@@B@@@BA@@B@@@@@B@@@B@@@BA@@B@B@@@BAB@B@@@@CB@@C@CB@@ABABEAA@AAEBC@C@C@C@C@EACBABAB@H@BAB@D@BAB@F@F@BAB@B@B@@@@AB@@@BAB@@@@@@@@A@@B@@@@@@@@@@@@@@@@A@@BA@@B@@@B@@@BA@@@@@A@@AA@@B@@@@@B@@B@@@B@@@B@@@@BA@@@A@@@@@A@@@@@@@BB@@D@@@@@@BA@@@A@@@AAAA@@A@A@A@@@A@AB@@@@@@@@A@@@A@@@@A@@@@@@A@A@@@A@@A@@AA@@A@@BABA@@B@@@@@BB@@@@@@@@@C@@@@B@@@@B@@@@@@@@@C@@B@@A@@BA@@@A@BB@@@@@@@@AB@AA@A@A@@@@A@@@@@@B@@A@@A@@@AA@@A@A@@@A@@@@A@@B@@@@A@@@@A@@@@@A@@@A@@@@@AA@@@@@@@@A@@@@@AA@@@@@@@AB@@@@A@@@@@A@@@@A@@@A@@@A@@@@@@@@A@@B@@@B@@@@AA@@@@@@@@A@@B@@@@@@@A@@A@@A@@@AA@@@@@@B@@@B@@@@@@@B@@@@@@A@@@@A@@A@@@AA@@@AA@@A@@B@@@B@@A@A@@@A@@A@@@A@@B@@A@@@@@@C@@@@@AB@@A@A@@AA@@@A@@@A@@B@@B@BB@@BABB@@@@A@AB@@A@A@A@@@AA@@A@@@ABABA@A@ABA@@A@@@@@AB@A@@A@@B@@A@@@@@AA@A@@@A@@@@A@@A@@@A@@@@@@@@B@@@BB@B@@@@B@@A@A@@@@@@BB@@@B@@@@@AB@@A@@@@B@@B@@@B@@BA@@@A@@AA@A@A@A@@@AAAA@@A@@@@B@@AB@@A@A@A@CB@@@BB@@@@@@@@@@@A@@B@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@@@A@@@A@@@A@@@@@@@A@@@@@@@@@@B@@B@@@@@@@@@AB@@@@AB@@@@@@A@@@@@@@@@AB@@@B@B@@AB@@@@@@@@B@@@@B@@@@A@@B@@@@@@BB@@@B@BA@@B@@@@B@@@B@@@@B@@@B@@@B@@@B@@@B@@@B@@A@@@@B@@@@@BA@@@AB@@@@@@BBB@@@B@@BB@@@BB@B@@@@@@@B@@@B@@@@DB@@@@A@@@@@A@@@@@A@AB@@@@BBB@@@B@B@@B@@AB@@@B@@@B@@@@AB@@@BAD@B@@AB@B@@BB@@@B@@@BA@@@@B@@@@A@A@C@A@A@C@@AA@A@@@E@CAE@C@A@@@@@@@A@@@A@@@A@@@A@@@A@AAA@@@A@@@@@C@@@@@@@@@A@A@@@A@AAA@@@A@A@A@@@C@A@A@@@@@A@AA@@A@C@A@A@C@A@@@@@AB@@@B@@@B@@@B@@@B@@AB@D@@@B@BAD@@@B@B@BA@@D@@@B@@@B@BA@@B@B@@B@@@@@B@@AB@@@B@@@@@B@@@@@B@AB@B@B@@@BAB@B@@@B@B@BAD@B@@G@C@I@G@GA@@I@E@MAA@E@AAC@A@C@A@A@C@E@@A@BADAD@BB@@@AB@B@B@DA@@B@B@@@B@@@@AB@@@B@@@BA@@B@B@BAB@B@@@B@B@B@@@@AB@B@BAFAF@@@B@D@FAB@BCXCZAD@BARA@C@I@K@K@cAC@G@Q@E@A@A@QAM@M@AD@@@BCDAAIA@A@A@AA@@@C@A@C@A@AAC@C@A@I@K@K@KAK@I@C@@@@@EACA@B@BI@C@@BC@EAG@A@A@A@A@A@C@A@A@@@A@A@A@A@@@E@A@A@A@@@A@@@A@C@A@@@C@A@C@C@A@@@@@EBA@E@E@E@A@KAG@@@C@@@@@A@C@C@@@@@@@A@E@@@C@C@E@C@I@C@A@@@A@@@A@@@AB@@@B@D@B@@@@@@AB@@@B@@@@@B@@@B@B@@@@@@@D@@@@@BAB@B@@@B@@@B@@@B@@@@@BA@@@@B@B@B@B@@AB@B@B@B@B@@@B@BAB@B@@A@C@C@C@A@@@@B@B@@@BAB@@@B@B@@@@@B@@@@AB@B@B@@@B@B@@A@@@@B@@@B@@@BAD@@@DAB@D@@@@@B@@ADAH@B@BA@@@@@AB@B@B@B@B@BAB@B@BBA@B@B@BAD@BAB@@B@@@@@@@BB@@D@B@D@@@@B@BAB@B@@@B@@@B@B@@AB@B@@@B@@@B@@AD@B@B@BA@@@@B@B@@BB@B@@@B@@@B@B@@BD@@@B@B@@@B@@BD@B@@@B@B@B@BBB@BCAA@BB@B@D@B@B@B@B@B@D@@A@A@A@A@@@A@@@@@@B@B@B@B@B@BAB@@@D@@F@@@@B@B@B@B@D@BA@@@@@@@@@@@A@A@@@A@@@AB@B@B@@@B@B@B@@@@AB@B@B@@@B@B@BAB@B@B@@@B@@@@D@B@@@@@@B@@@@@@AD@B@DAD@B@DADAD@D@B@B@@@@FBAD@@@DAD@DAD@B@B@@FBH@FBH@HBF@FBH@HBF@HBH@HBH@FBH@HBB@B@AHCNCTB@BBB@BBDDDBDB@B@@@@@@@@@@B@@@BBBBB@BBDD@@@@@@B@BB@@BBFDDB@B|HJB@@@AP@@@@@@BBD@F@D@B@B@BAB@@@B@@@@@DAB@DAB@DAD@@AB@BAB@BAB@@@BAB@@AB@BAB@BAB@BAB@B@BAD@@@B@@@B@@@@AB@B@@@@@B@@@@@B@@@@@B@@@@@BA@@B@D@B@B@B@@@B@D@B@B@B@BA@@B@B@B@B@D@@@D@B@B@D@B@B@D@B@BAB@D@B@D@D@B@D@D@B@D@F@B@F@BBB@B@B@B@B@B@B@B@B@B@@@B@@BB@B@@@B@B@B@B@B@B@B@@@DBD@D@D@D@B@B@DBB@B@B@@@B@B@B@D@B@HBB@B@AJA@C@A@@BA@@@@B@B@@AB@B@B@@@BAB@B@@@@@B@B@@AB@@@B@@@B@@@B@@@@@@A@@B@@@B@@@@@@@B@@@BA@C@@B@@@B@BAB@F@BAD@@@B@B@@@@@@@BAB@B@B@B@BAB@B@@@BAB@B@@@@@@DBDB@@BB@@DBFDDBBBFBDB@@FDB@DBBBB@@@DBFDB@DB@@B@@BBAB@@@@@B@@@@@B@@BP@@BD@B@D@B@B@B@B@@@DBD@D@D@DBD@D@D@FBD@@@@AFQBIBA@@D@B@B@F@DBJ@AB@D@D@D@FAD@F@DJB@DAD@BA@AD@B@DAB@B@B@DADH@HB@@@BAJ@DAB@B@B@B@B@@@DAD@D@B@D@@@BEA@@@B@@@@@BAD@@@B@DAD@@@B@BAB@B@@@D@D@@@@A@@@@@@D@@@D@@AB@B@B@BAB@@@B@@@DAB@B@B@@@B@@AD@D@B@BAHCN@D@B@@CA@BB@@@@@@B@@@@@@@B@@@BAD@DAB@B@@@B@@@DCPAB@B@DAB@B@DAH@@@B@@@BA@@@@B@@@@@@@B@@AB@D@DA@@D@@@DAD@AA@@BD@@BA@@B@B@@@B@B@BA@@@@@@B@@@@@@@@@@AJCJ@DAFAB@B@B@F@B@L@@@BB@B@B@BAB@B@B@@@BAB@@A@A@A@A@A@@BA@ABABA@A@@B@DBB@@@BAB@DAD@BBB@@B@D@B@BADA@@BBB@BB@B@B@D@B@@@@@@BA@@B@B@B@@BB@@B@B@BAB@BB@@BB@@B@BBF@D@BBDB@@BBBAB@B@FAB@D@B@@BB@@B@B@BDBB@BBB@@BB@@B@B@D@D@@BB@@B@B@B@@@BA@@AA@@@AB@@@BAB@@AB@@A@@@AB@B@B@B@@AB@@ABABAB@B@BBBBDD@@B@@@B@BAB@B@B@D@B@B@@@BB@B@B@@BBBBB@DBB@B@B@BA@@@A@A@A@A@@@AB@@@B@B@DB@@BAB@@AB@B@B@@BB@D@B@B@BADAD@@@F@BA@A@@BA@ABADAD@BAD@BAB@BA@@D@B@@BB@@B@BBB@@B@B@@@BAB@BBB@BB@@B@D@@@B@BAB@D@B@BBB@@B@@AB@B@@@BBBBDBDBB@B@@B@@@B@BBB@@BBB@@@B@@@BBB@@BDBFB@@BB@"],"encodeOffsets":[[128725,49725]]}}],"UTF8Encoding":true});}));