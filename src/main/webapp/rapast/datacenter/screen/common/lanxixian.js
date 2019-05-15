(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('兰西县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"231222","properties":{"name":"兰西县","cp":[126.289315,46.259037],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@BABAD@DCDAFCDADCB@DD@@DBBBB@DDBBDBDDDB@@@@DDDB@@@@@@DAF@BA@@@@DK@@AACAACCACCAACCCAAAAAFCDAJEB@DCHGB@HIFE@A@@@AB@BA@@B@BE@A@@B@@AB@@A@ABGBA@A@CB@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@A@@@@@@B@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@BAB@BADAB@@AD@BAB@BAB@DA@@BABAFABADABADABAD@@AB@@@B@BAB@BABAB@DABAB@BA@@@@B@@@@@BAB@FAB@B@B@B@DAD@B@BA@@B@B@@@@@B@@@B@FAD@FAD@B@D@BABAB@DA@@B@@@DABADA@AB@@AB@BA@@BA@@BABA@ABAB@@A@@B@BA@AB@BABA@@BA@@B@@ADABABABA@@BABAB@BABABABAB@@ABABABABADAB@BA@ABABADA@AB@BADA@@B@@A@@BABC@@BA@@@@@AB@@A@@BA@@@@@AB@@@@@BABAFCJEBADCFCFCBABADABADCBCB@D@D@D@BBD@F@@@B@@@@@BB@@D@@@@@D@@@DB@@B@B@B@@BB@@@B@@BD@B@@@BBB@B@B@BB@@B@B@B@@@BBB@@@F@B@@@B@DBB@D@B@B@B@@@B@D@D@B@B@F@@@@@F@D@B@F@B@@BB@@@B@B@B@B@B@@@B@@@B@B@B@B@B@B@B@B@D@B@B@@@B@@@B@B@B@B@B@D@B@D@D@@@FAB@@@B@B@B@B@B@B@@@B@B@@@@@B@@@@@B@B@BAB@B@BB@@B@@@D@B@@@B@@@B@B@B@B@@BB@B@@@@@B@@@@@B@@@B@@@B@@@BBB@@@B@@BB@@@BB@@@@B@@@@@BBB@@@D@@AB@B@@@B@B@@@BBB@B@@@B@@@B@@@B@@@B@@@@@B@@@@@B@@@@@B@BB@@@@B@@@B@@@B@@@@@B@@@B@@BB@B@@A@@B@@@@@@@B@@B@@B@B@D@B@@@@@B@@@@@BB@@@D@@A@ABAB@@@@@B@@@@B@@@B@DBB@B@B@BAB@@@BB@@B@@B@@B@B@B@B@@@B@@@B@B@@@BB@@B@@@@B@@@@B@@@BBB@@BB@BBB@@@BB@@@@B@@@B@BBB@@@@@B@@@BB@@@@B@@@@@@@B@B@@@BBB@@@@B@@B@@@B@@A@@@BB@B@@@B@@@B@@@@@@@@@@@@@@@@@@BB@B@@@@BFDHNDFDDBHDFDDFDBB@BB@BBD@F@DAH@F@B@B@BD@B@B@BADAD@B@@BBBBB@D@FAD@BBDBDDHDDBD@H@@@@ABAB@BB@@D@@@BA@@B@DAD@HCDAF@DA@@FAJC@@FA@@B@@@HCD@B@BA@@DAD@DA@@DAB@@@B@@AAAAA@A@@@A@@@@B@@@@@@@@A@@@@@@@@@A@@BA@ABABABA@AB@@A@@B@@A@AB@@A@@BA@@@A@@@@BA@@@@BA@@BA@AB@@@@ABAB@@AB@@@B@@@@BB@@AB@BA@@@A@@@AB@@@@ABA@@@@@@BABA@@BA@@BA@ABABA@@BA@ABA@A@@@@@@@A@@@A@AAACE@@B@BA@@B@B@B@B@BAB@BA@@BA@A@@@@BA@@@A@@BA@A@@@A@AB@@A@@@ABABA@@BABC@@BA@A@@BA@@@AB@@@@AB@@@@@@@BCBCKAA@@ABC@@BC@AB@@BB@B@B@BAB@@@BA@@BA@@BA@AB@@AB@@ABADAB@DABAB@@@B@BADA@@@AB@@@BADCDEFCDCDCBCDADABA@AB@BA@ADA@CB@@AB@@A@A@@B@BC@@BABABABA@@@A@@@@A@A@A@C@A@@AA@@@@@@@@A@@@ABA@C@A@ABA@@@@B@@ABB@AB@@@B@@@@@@AB@@A@@@AB@@A@@@@@ABA@CB@@A@ABA@@BA@A@ABA@CB@@BB@@@B@B@@@B@@@BBB@@@BC@A@@@A@@@@BA@A@@@ABC@A@@@ABA@@@CBC@A@ABA@A@@B@@A@@@A@CBA@ABA@ABC@@BAB@B@B@@@B@DABAB@@@B@@@B@BBB@B@DBB@@@B@DB@@BA@@@A@A@A@A@A@A@A@A@A@A@A@C@A@A@ABA@@@@AA@@@@@A@@@C@@@A@A@@@A@A@@@A@C@@@CBE@C@EBC@@DAHBJ@BBD@B@DBB@F@B@@A@ABA@C@CBC@CBE@CBC@CBC@E@@BC@A@CBE@@AAAECAACCEACCECCACCCAECCAA@ACC@ACCACAC@@A@AA@@@A@@@@B@@AB@@A@@@@@ABA@@@AA@A@A@@A@@@A@@AA@@AA@@@A@AAA@A@@@AB@@@@@@A@AB@@@@@@A@ABA@A@@AACCEEEEGGGGIICCCCECAAMCIACACAWEICGAEACAC@AAIACAMCA@AAECCAWQIEECIEEEGEECECGEGEKIUMCAAA@ACG@CAGAG@@BABA@@@BB@@A@@@AB@@@BABABA@@@@@@A@AB@@A@A@@@BA@@AAA@@A@AAAC@A@@AC@A@@@A@A@ABA@ABA@@@AA@ABCAAA@BA@ABEACAEACECCAA@@@AAAA@ABAB@BAAAA@A@A@CAA@C@A@@@@@A@@A@@AA@A@@@A@A@@@A@@@@A@@@@@A@A@C@C@ABA@@@A@AB@@@@@@@@@@@A@A@@@@@A@@A@@@A@C@A@C@A@A@A@A@A@@@CBC@C@C@CBA@ABA@ABA@@B@B@@A@@@@@@@AB@@@@@B@@@@AB@@@@@@A@@@@@@A@@@@AA@@@@@@A@@@A@@@@@A@A@@@@@@@@B@@@@A@@@@@@@@@@@AA@@@@@@@@@@@@A@@@@@@@A@@@@B@@@@A@@@@@@AA@@@@@AB@AA@@@@@A@@@@@A@@B@@@@A@@@A@AA@@A@@@@BA@@@BB@@@@A@@@A@@@A@@B@@@@A@ABA@@@@@@B@@AB@@A@E@C@A@@AAA@AAC@@@A@@@@@@@A@@A@A@C@@@A@A@A@AA@@@@A@@AAA@@BA@@@C@E@@AA@@@@@AA@@A@@A@@A@A@@@@@@@@A@@@A@AAE@A@@@@A@@@@@@@A@@@A@@@C@A@@@A@A@A@@@@@@A@AAA@A@C@A@AAA@C@AAA@C@C@A@EAG@EBA@A@ABCDAB@@A@ABC@A@C@A@A@EAEAC@A@A@A@A@C@CBABA@@BEDCDAB@BCBEDA@@@@@@@A@E@CAA@@@AAA@C@E@E@@@@@AB@@@@AB@@A@@@A@@@@BA@A@AAA@A@AAAAAAAABCBCFBH@D@BABC@CBA@@@A@@C@CAA@@ABAC@@@C@A@E@A@C@C@@AA@@@A@@@@@@A@C@C@E@ECAE@@B@D@B@B@B@@A@A@AAA@@@A@A@CBEFEDCB@BA@A@ABCDCBEDGFECEAEAEAOG@BA@@@AB@BABAB@@AB@BA@AD@BA@ABAB@BAB@BA@AB@BABAB@BA@@BA@@BAB@@@@@BABABABAB@@@B@@A@@BABAB@@@@ABABABAB@@ABADA@@B@@@@@@@B@@@@ABADA@@@@@@B@@ABABABABABAB@BCDAB@@AB@BABA@AB@B@@AB@BA@AB@BA@@BA@@BA@@@@BA@ABABADABA@ABCD@B@@A@AB@BCBABADABABAB@@AB@@@@@@A@@B@@@@ABABABA@AB@@@BABABA@@BA@ABABA@ABABAB@BA@@@@B@@ABA@AD@@@BABA@AB@B@@AB@@@@@@@@@BABADAB@@@@@@AB@B@B@DAB@@AF@B@BABCFCFEJABADAB@@CDCF@@EFCF@@@@CFCFCFCBADADABABADA@@@CDEHABCFEH@BA@CFEJ@B@@A@@@AB@@@BABABAB@DA@@@ABCF@BCDADAB@DA@AD@BADCBAD@BINAFEH@B@BIP@@CH@BEHITCF@DGNCF@@AB@@KH@@ABKF@@A@IFEDEBQHMFGDCBABUJQJUJIF@@GBEDA@ABGDKFEBEDEBEDCBEBABA@CBEDCBCBA@CBKFKDQH@@E@@@OFA@@AA@CHGBCBEBUJQFABCA@@A@@@@@A@AAA@A@A@AA@@A@@@GA@B@B@@AB@@@BAD@@@B@@@@AB@@ABAB@@AB@@ABABABCDABA@@B@@@@A@@@ABADCBABAB@B@@AB@BABAB@@AB@@@@@@A@@BB@@@@@@@@@B@@@@@@@@@@@@B@@AB@B@@@BB@@@B@@@@B@@B@D@B@B@DBB@D@@BB@D@B@@@@B@@@B@B@@A@@B@B@B@@@B@DAB@B@D@@B@AD@B@BAB@@@@DBABABA@@BABABABA@ABCAA@AAAB@BABAB@BABAB@BABAB@@DBBB@@AB@BAB@BA@B@@@BB@@B@A@@B@BAB@B@@@B@B@B@@@BAB@@@B@BBBB@@BA@@B@B@@@B@B@B@@@B@B@@@BA@@@A@@B@B@@@B@B@@@B@B@B@B@@@@BB@@@B@@@D@@@B@B@@@BAB@B@DAD@@@@@B@@@B@@@B@B@B@@AB@B@B@@@BAB@@AB@BAB@@@BAB@BABAB@BABAB@BAB@BAB@@AB@@@@@B@@A@AB@BA@AB@@@@A@A@@@A@@@B@BBB@B@@@@B@@@BB@@@@BB@B@@@BBB@@@B@BB@@B@B@@@BB@@@@@@AB@@ADA@@@@@B@BBB@@@DBD@BB@@B@B@@BB@@@B@@@DB@@B@BB@@B@BBB@@@BBB@@@@@B@@@B@@BB@@@B@B@@@B@BB@@B@@@B@@@B@@BB@@@@@B@B@@@@B@@B@@@B@@@@@@@@@@@@B@@@@@@@@@B@@@@@@@@DBB@@@B@@@@B@@B@B@B@@BF@@@B@BBB@@@B@B@@@BBB@@@B@@@B@B@B@BBD@BBDB@@B@B@BBB@@@B@@@BBB@B@@@B@@@B@@@BBB@@@DBB@BBB@@@ABB@B@FBDB@@BABA@A@@@@B@B@@BB@B@@@B@B@@BB@D@FBDBB@B@@BB@@@B@@BB@B@BBB@B@@BB@@@BBB@@@B@@@@@B@@@B@B@B@B@DBD@@@B@B@B@B@B@@@B@D@@@D@B@B@BAB@@@D@B@B@DBB@B@BBB@@@F@FBB@DBD@B@B@B@BBF@BBD@BBB@B@BBB@DBBBB@@@@@BB@B@@B@DBB@DDDBBBDDB@DBDD@@DBFD@AD@BABADA"],"encodeOffsets":[[128947,47757]]}}],"UTF8Encoding":true});}));