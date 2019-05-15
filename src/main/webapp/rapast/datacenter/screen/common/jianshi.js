(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('集安', {"type":"FeatureCollection","features":[{"type":"Feature","id":"220582","properties":{"name":"集安市","cp":[126.186204,41.126276],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@BABA@AB@@A@ABA@@@A@@B@@@BAB@@@B@B@B@@@BB@AB@BA@@BABA@AB@BA@@@BB@@@BBB@B@BBB@B@B@B@@ABAB@BABA@ABABADABA@A@AB@BA@@@@@@@@@A@@@A@@@@@@@A@@@A@@@A@ABAA@@@AA@@A@@AB@@AB@@A@@@AA@@A@@@AA@@A@@@@@AB@B@BA@@@@BA@@B@@AB@@A@@@@@AA@@A@@AA@@@A@@B@@@B@BA@@@@B@@@@@BA@@@@B@@AB@@@BA@ABAB@@@@A@ABA@@B@B@BA@@B@@AB@@AAAA@@ACA@@@A@A@AB@AC@A@A@ABA@A@A@@@A@AA@@A@@@AAA@@@@AA@@@AA@@@@A@@@A@@@@@A@@@@@A@@B@@A@@@ABA@A@A@@AA@A@AB@@@@AB@@@@A@@B@@A@@@A@A@ABA@A@@@AAA@@@AA@@A@A@@@@@@@AA@@A@@AA@@@A@@@A@@@A@AAA@@AAAAA@A@@AA@@A@AAA@@@@BA@@BAB@BAA@@AAA@A@A@A@@@@@A@@@AA@BA@@@@@A@A@@A@@AB@@AB@B@B@@@DA@@BAB@B@BAB@B@D@@AB@@@B@@@B@@@D@B@B@BA@@@@B@@@@@B@@@B@@@B@@AB@@@@@@@@A@A@@BA@@@A@@@A@@@A@A@@BAB@@@BA@@@A@A@@@A@@@A@@@@@A@@@@@A@@@@@A@AA@@A@@@A@AA@@@@A@@@@@A@@@A@@A@@A@@@A@@B@@@B@BA@@@@BA@@B@@AB@@@@AB@B@@@BA@@@@@AB@@@@A@@AA@A@AAAB@@A@A@A@A@@@AA@@A@@B@@A@@@A@@@AB@@A@@@A@@@@@@@@@@@A@@B@@A@@@A@A@A@@@A@@A@@AB@@@@@BA@@@@@AB@@@B@@@BA@@@@@A@A@A@A@A@A@A@@BA@@@A@@@@BA@@@@@AB@@@B@@@B@@@BAB@B@B@D@B@B@D@BBB@D@BB@@@@BBB@@@@BB@@@B@@BB@@@B@@@@@B@@@@@@@B@@@@A@@AA@@BA@ABAB@DADAB@B@@A@@@@B@@A@@@@@@DAB@BAB@B@@@B@BAB@B@B@@@BB@@BB@@B@@BB@@@@@B@@BB@@@@@BBB@B@B@B@B@B@B@@B@B@@@B@@@B@B@@B@DB@BBBB@@B@@DBB@B@B@B@@@BA@@@@B@@A@@@@B@@AB@@@B@@@@AB@B@@@B@@@BBB@@@B@BBBBB@BB@@B@@@B@@@B@@BB@B@B@B@BB@AB@B@B@F@D@B@@AB@B@D@B@@@B@@@B@BBBB@@B@B@B@@@B@BB@@B@@@@@B@@@BBB@BBD@BBB@B@BB@@@@BB@@@B@B@@BB@@BB@@B@@BB@@@@B@@B@@@@@B@@@@B@@B@@@@BB@@@@B@@B@@BD@BBDBBB@@BBB@BBB@@@@@B@@@@@@@B@@@@@@@@@@@B@@@B@@@BA@@@@@@@@B@@@B@@@@@@@@@B@@@B@B@@@@@B@@@B@B@@@@@B@@@@B@@@@@B@@@@@@@@@@@B@@@@AB@@@@@@@B@B@@@B@@@@A@AB@@@@A@@@@@AB@@A@@@@@@B@@@@@@AB@@@@@@A@@@@@@BB@@B@B@@@@A@@BA@@B@@@@@B@@B@@@BB@B@BB@@@@B@@B@@B@B@B@@@@@@B@@BB@BBB@@BB@@@BB@@@BB@@B@@B@@@@B@@@@@B@@@@@@@B@BBB@B@@@@@B@@@@A@@B@@@@@B@@@@@B@@@@@B@@A@@BAB@@@@@B@@BB@@@B@@BBB@@BB@B@@@D@@@@@B@@BB@B@@@@@@@@@@B@@B@@@@B@@@@@@@B@@@@@BB@@B@@B@B@B@@@@@@@@@B@@B@@B@@@B@B@@@B@@@B@@B@@@@B@@B@@@@B@@@B@B@@B@@@@@@@@@@@@B@@@@@@B@@@@B@@@@@@BBB@@@@B@@B@@@@@@@B@@A@@BB@@@@B@@@B@@@@@@@B@@@@@B@@B@BB@@@@@BA@@B@@@BB@@@@@@BA@@B@@@@@B@@@@@@@@@@AB@@@B@@@B@@A@@@@B@@@B@@@B@B@@@@@@B@@BB@@@@BB@@@@@@@B@@@B@@BB@B@@@@@@@BB@@@@B@BB@@@@B@@@@@@@BBBB@@@@B@@@@B@@A@@BB@@@@@B@@BB@@@B@@B@@B@BBB@@B@@@@BB@B@@@@B@@@B@@@@@B@@@B@@@B@@@BB@@@@B@@@BBB@@@B@B@B@B@@@B@@@@@@BB@@@BB@@B@@@@@B@@@@@@BB@@@@@BBB@@@@@BB@@B@@BB@@B@@B@@@B@B@@@@B@@B@@BB@@B@@B@@B@@@B@@@B@@@@@@@@@B@@A@@@@BA@@B@@@BA@@@A@@B@@@B@@@B@@@B@@A@A@@@A@@@@BA@@BA@@B@B@B@@@BA@@@CB@@A@@B@@@@@@@BB@@@B@@B@@BB@@@B@@@B@@BB@@@@@BB@@@BB@B@@@BB@@@@@@@BB@@@@@B@@@@@B@B@@@B@@@@@B@@@@@@@B@@A@@B@@@@@@@B@@B@@@@BB@@@@B@@B@@@@@@B@@@@BB@@@@@@@B@@@@@@@BBAB@BA@@D@B@B@B@@@B@B@B@B@B@B@B@B@BA@@BAB@BA@@B@D@@@B@@@D@B@BABA@@B@B@D@@BB@BBD@@@B@B@@B@B@B@B@@B@@B@@@@@B@@BBDB@@B@B@D@@@DAB@B@B@B@BBB@D@B@B@DA@@BBB@D@B@B@B@BADA@A@A@A@A@A@ABA@@@@@A@@AA@@@A@@@A@AAA@A@A@A@@BA@AB@BB@@@@B@B@@@B@@@BB@@@@BBB@B@B@B@@@BBB@BAB@@@B@BBB@B@B@BAB@B@DBB@D@B@B@B@@AB@@@BA@@B@BAB@B@@@BB@@@@@@BBB@@@@@BBB@@B@@@@@BB@@BB@B@BD@@@B@B@@@@A@@B@@@BB@@B@@B@@@@@@@@@@@BB@@BB@@@@@@@@@@@@A@@B@@BD@@@BB@@@@B@B@@BB@@@BBBBB@@@BAB@@@@BBBBBB@@@B@B@@B@@BB@@BBB@@@@@@B@B@@@B@B@D@@@D@B@B@@A@@@@B@@@@@BBB@B@@@DADAB@@@DAB@@@@@B@@@BBB@B@@BDAGEAA@A@CAC@CA@@@A@A@CB@@A@@@@@@@@@BAFABABA@ADE@A@@@@@A@@A@@AA@A@CBA@@@@A@@@@@C@A@A@@AA@@@@A@@@E@@BA@@@@A@@@@@@FABAB@@@@A@@@ACCAC@A@@@A@C@A@@BA@AFCBAB@@@B@DAB@B@@@@@@@@@@A@@GCAAUKCCA@@@AA@AACCIAEAE@CAA@@@AA@@@@@A@AB@@@@A@@@@A@C@@@A@@@@@AA@@@A@A@A@@@A@@A@@@@B@BA@@@@@@@A@@@A@@IQCC@AA@@@A@CGCM@A@@@@@A@@@A@AA@AA@@A@@A@ABC@CAEAEAC@ACC@A@C@C@ADGFGHM@A@@DABAB@PGLEJEHCHEBABA@ABA@@@A@AAA@AACCCACCACCCCEACAA@C@CAC@C@E@C@GBE@E@E@SAG@A@A@A@AB@@@B@B@B@BB@BBB@DBF@B@B@D@@@D@B@B@B@F@FBB@BB@BB@@@D@D@DBDBDD@DBDAB@D@BABABABA@CBIBG@E@G@G@EAGACACCSKGACACAYEIAEAAACAAA@@AA@ACI@A@C@A@A@ABEBA@A@@@A@@AA@@AA@@A@A@IBGBE@C@AAC@AAA@CCAAACAAACAECICICCACCCCCCCUMKECCAAAAGECCAA@A@@@A@E@A@AA@@A@AACEKACAA@A@A@A@ABG@A@CAA@CAAAAAAAACAAAGAOCICGCGCEAAAAAAAAAAA@AEIACACAA@A@AAG@ACSAG@CAA@AA@@AA@A@E@GAK@E@AAA@@@AA@@@A@@@@@@@A@@BA@@@A@A@CBA@A@A@@BABEBC@A@A@A@@AA@AAAACCCCAECCAECCAC@CAWCGAGAEAKCICA@AAAACAA@@AAA@CCM@AAA@AA@A@AAC@ICIAEAC@KEICEAEACACA@@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@@A@@@@@A@@@@A@@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@@@A@@@@@A@A@A@AA@@AAA@AAAAAKGKGICECEAGAG@IA@@@@E@C@EBGBKBA@A@A@C@AAA@AAAAEEACAACEACAA@A@A@A@ABA@ADABAFCDAFAFAHABAB@@A@@BA@CAA@AACKK@AAG@ACAKEC@CAABE@EBA@CAA@ACCAAAAA@AAC@CBA@CBC@CNSBCBA@C@A@A@AA@AAC@EAC@ABC@ODCBC@A@C@CAEAIECACAACAAAA@C@A@A@CBABAZUBABA@@@AAAECEEEAA@CAI@GAC@EAAACAAA@C@A@C@CBE@@@CBAAA@A@AAACAMEEAAAAA@A@A@A@CBABGBA@AA@@AA@AAC@C@C@ABCBCDGDCDCBA@EBC@G@C@C@A@CAGECAA@CAEAECCACCEEEEACAAAC@A@A@ABAB@DADAF@BBF@ZND@DBB@D@B@JCHADCHCDCBABC@@BA@AA@@ACAEAE@CAE@EBC@AAC@GCEAC@C@A@CBA@CBIFEDCBABC@C@C@AAA@AAAAAA@ACEAAACA@@A@AA@@@@@BA@@@@@@D@@@B@@@@@@AB@@@@@@AAA@A@@AAAA@@CACACACAA@A@OCA@G@EAGBC@GBG@EBCDEBEFCD@BAB@B@B@B@DBB@BDDFFBDBB@B@B@B@BA@@BABA@A@A@ABAAA@A@@AAAAACEACCCAAC@AAE@A@E@C@ABCB@BCDCDEDE@A@C@C@AAAAAACCAA@@ACAECGACACCCCAECCACAC@oYA@CACACAEAC@A@A@A@A@@@A@ABA@ABABA@@BA@@B@@@B@@@BB@@@@@@B@@B@BAB@@@B@@@@@B@@@@B@@@@@@@@ABA@@@@@@BA@@@@BAFABADABCBABABCBCBABABGFIDEBGBCAC@AAA@AACACCGGEEECCAGCEEMEGAGB@@C@E@C@A@CAG@ECGCCAA@@@A@CC@B@DCJCFINKPILIFKFMDGDGFEHGBEBEACA@C@EAAACEACBKBI@IAMCOCSIQGICE@IBCFAFBFDJHHDDBFAFBB@@@@B@@AB@BA@@@@BB@@@BB@@B@B@B@B@@@BB@AB@@@BAB@@@BA@@B@B@B@@B@@@B@@BB@B@B@@@B@B@@BB@BBB@BBB@@@@BB@B@@@BBB@B@BB@@B@@BB@@BB@B@B@@BB@BB@@B@B@B@B@B@B@BBB@B@B@B@@@B@BAB@@@B@BB@@B@@@B@@AB@B@B@@@B@@@BB@@BB@@@B@BB@@B@@BBBBB@@@DBB@@@@@@B@@@@AB@@@B@@@@@B@@@@@B@B@@BB@@@@BB@@B@@B@@@BBB@@@BB@BB@@@B@@@@@BAB@B@@@B@@@BBB@@BB@@BBB@BBB@BBB@B@B@BB@@B@@B@BB@BB@@B@@@B@B@BB@@B@@@B@@@BAB@BA@@@@BA@@B@@@B@BA@@BB@@B@@@BBBBB@@@@B@B@@@BB@@@@@B@@@B@@B@@@B@B@@@@@B@@BB@BB@@@@@@BA@@B@@AB@@AD@BAB@@BB@@@B@@@B@BABA@@@@B@B@B@@B@@BB@@@@@BB@@@@A@@B@@@@@@@B@@@@@B@@@@@BA@@@@@@@@B@@@@@@@@@@BB@@B@@@@BB@@@@@@@BB@@@@B@@@@@@B@@@@@B@@A@@B@@@B@@@@@B@@@@@@AB@@@@@@@B@@@@@@@B@@@@@BB@@@@@@B@@@@@@@B@@@@@B@@@@B@@BB@@@BB@@@@@BB@@@@BB@@@B@@BB@@@B@@@B@@@@@B@@@B@@@B@@B@@B@@@@B@@@@@@BB@@@B@@B@@@@BB@@@B@@BB@@@@@B@@@B@@@B@@@B@@@@BB@@@@@@B@@@BB@@@@B@@@@@@B@@@@@BB@@@@@@@BB@@@@@@@@BB@@B@@@@BB@@@@@@@B@@@@@@@BB@@B@@@@BB@@BB@@BB@@B@@BB@@@B@@BB@@@@BB@@BB@@@BB@@@@BB@@@@BB@@@@BB@@@@BB@@A@@B@@@@@B@@@@B@@B@@@@@B@@@@@B@@A@@B@@@@@@@BB@@@@@BBB@@B@@B@@BB@@B@@@B@@B@@B@@@BB@@B@@@@@B@@@@@B@B@@@@@@@BA@@B@@B@@B@@@@BB@@B@@@@BB@@BB@@@@@@BA@@B@@@@@BB@@@@B@@@@BB@@@B@@B@@BB@@B@@@@@B@@@B@@A@@B@@A@@@A@@B@@@@AB@@@@@@A@@@A@@@A@@B@@A@@@@@@B@@A@@@@@A@@@@@A@@@@@A@@@@BA@@@@@A@@@A@@@A@@@@@@@AB@@@@A@@@@@A@@@@@A@A@@@@@A@@@@@A@@@A@@@@@A@A@@@A@@@AA@@@BA@@@@@@B@@@B@@@@@B@@@B@@B@@@@B@@@@@B@@@B@@B@@B@@@B@@@@BB@@B@@@@BB@@@@@@@B@@BB@@@@@B@@B@@@@@BB@@B@@@@@@@B@@@@@B@@B@@B@@B@@BB@@B@@@@@B@@@@@BB@@@@BB@@@B@@@B@B@@@@BB@@@@@@B@@@@@B@@@BB@@@@BB@@@B@@B@@B@@@@@@BB@@@B@@@BBB@B@@@B@@AB@@@B@@AB@@@B@@BB@@@B@B@@@@AB@@@B@@@B@@BB@@@@B@@B@@B@@B@@B@@@@B@B@@BB@@@B@B@@@@@B@@@@@@BB@@@@BB@@B@@@@BB@@@B@@AB@@@B@@@B@@BB@@@B@@@BB@@@@BB@@B@@BB@@@BB@@@@@@BB@@B@@@@@B@@@B@@BB@@@@B@@B@@@@BB@@@@BB@@B@BB@@B@@@BB@@@BB@@@BBB@@@B@@@B@B@@@@@B@@@@@@@@B@@BB@@@BB@@B@@B@@B@@B@@BB@B@@B@@B@@BBBB@@@@@BBB@@@BB@@@@@B@@A@@BA@@@@@A@AB@@@@A@@B@@A@@BA@@@@@@@A@@@AB@@@@@@AAA@A@A@@AA@@@A@@@@@@@A@A@@@A@@@ABA@C@@BA@@@A@@@A@@@A@@@A@A@@@@@A@@@A@@@@@A@@@A@@@CB@@@@AB@@@@@BA@@@@@A@@@ABA@@@A@ABA@@@A@@@CBA@@@ABC@@@A@@@A@@@AA@@A@@@A@A@@B@@@@A@@B@B@B@@BB@@@B@@@B@@@B@@B@@BA@@@@B@@@BA@@B@@@@@B@@@@@BA@@@@@@B@@A@@B@@@@B@@B@@B@@B@@B@@@@B@@@B@@@@@@AB@@@@@B@@@@B@B@@B@@B@@B@@@@@B@@AB@@@@B@@@@B@@BB@B@@BB@@@B@@B@@B@@@@@B@@@@BB@@@@@@@B@@BB@@@@@BB@@BB@@@@BB@@@BB@@@@@B@@@@@B@@@@@B@@B@@@BB@@B@BB@@BB@@@@@@B@@B@B@@B@@B@@A@@B@@@B@@@B@@@@@@BB@@@@BB@@@@BB@@B@@@@@@B@@@B@@AB@@@@@BA@@@@@@@@@@@A@@@@@A@@B@@@@A@@@@@@B@@A@@B@@@@@B@@@@@BA@@B@@@@@B@@A@@@@B@@@@@@@BA@@B@@@@A@@@A@A@@@@@A@@@@@A@@@A@@@A@A@@@A@@@AA@@A@@BA@@@A@@@@@A@@@@@A@A@@@A@AA@@@@A@@@AA@@@@A@@@A@A@A@@@A@@@A@@@A@A@@@A@A@@@@@A@@@@@@@AB@@A@@BA@@BA@@@ABA@@@@B@@A@@@@@@@A@@@A@@@@AA@@@A@A@@@A@@@A@A@A@@@A@@@@@A@@@A@@AA@@@A@A@@@@AA@@@@@A@AA@@@@@@@@A@@@AB@@A@AB@@@@@@@@@@B@@@@B@@B@@B@@@@@B@@@@@@@@@BA@@B@@@@@@@@@BB@@B@@@@A@@B@@@@@@@@@B@@@@@B@@@B@@@B@@A@@B@@@@@B@@@@@@A@@B@@@@@@@B@@@B@@@@A@@@@B@@@@@@@B@@A@@B@@@@@@AB@@@@@B@@@@@@@B@@@@@@AB@@@@@B@@@@@@@B@@@B@@@@@@@@AB@@@@A@@BA@@@@@A@@@@@A@@BA@@@@@A@A@@B@@@@@@@@A@@@A@@B@@A@@@@@@@AAA@@@AA@@@@A@A@@@@@@@@@@A@@@@@A@@@@@A@@A@@@CA@@AA@@A@@@@@@A@@@@@@@A@@@@AA@@@@A@@@A@@@A@@@A@@@A@@A@@A@@@A@@@AA@@@@A@A@@AA@@@A@@@A@A@AA@@A@@@A@@@@@@@A@@@@@@B@@@@@@@@@BA@@BB@AB@@@@@@@BA@@B@@@@@@AB@@@@@@@B@@@@@B@@@@AB@B@@@@@@AB@@@@A@@B@@A@@@@B@@A@@B@@@@@@@@@B@@@B@@@B@@@@@B@@ABBB@@@@@B@@@B@@@B@@B@@@@@@@@B@@B@@B@@@B@@@@@@BB@@@@@B@@@@@B@@@B@@@B@@@@@B@@@@@@@@A@@B@@@@A@@B@@@@A@@@@B@@@@AB@@@@@BA@@@@BA@@@@@@@A@@@@@@@@@AB@@@@@B@@@@BB@@A@@@@@A@@@A@@BA@@@@@A@@@@B@@AB@BA@@@@BA@@@ABA@AB@@@@AB@@AB@@A@@@@@@@@B@@CFLDHDD@JHFLBNELSTMNIDLPHHFDHFJDHBD@FAFCDAFEFCF@F@F@HBHDFBBDBB@DADAB@@CBGDGDGDGFCBCDCDADAB@BAB@D@B@B@BABB@@BBBFBD@F@H@FAD@DAB@BAB@B@D@B@BBBB@DBBBDBFBDBF@DAB@DAB@@@B@@BBBBB@@BB@DDBBBD@F@BBDBDBDFDDBDBDBF@B@D@D@D@D@FAFAD@BAD@B@D@FBF@D@F@BBDBBBBB@BBBDBD@BBD@B@D@DBBBDB@BDBDBBB@DBBB@BB@@@@@B@BAB@BABCBEDABABCDAF@H@@BDBDDDB@DBD@HCFADCFCFADADAB@FBF@B@FBF@BBB@@B@@@B@@ADAF@@@D@DBBBFDDBFBD@B@B@D@D@B@BABA@ABE@CBCBC@@BABADABAD@D@B@@@B@@@BBDBDBBBBBBB@B@@@B@DCBAFABCBABAD@BAD@DAF@D@B@BBBBD@HBFBFBDDDDBB@B@D@FAB@DABAFAD@D@D@B@BBDBB@BB@D@D@H@F@HBF@B@@@BBBBBBD@B@DBHB@@BA@@BA@@BA@@BBB@@B@@B@BBB@B@@@BBB@@AB@BAB@BAD@@@B@BBB@@BBBB@@@AB@@@BB@@B@@@B@B@@@@B@@@@@BB@@@BB@@B@@@B@@A@@B@@@BA@A@@@@@@B@@BB@@@B@@B@@BBB@@@B@@A@@B@@@@@@@@@B@BBB@BB@B@@BB@BBB@BBB@B@B@B@B@BBB@B@B@BA@@B@@@BA@@B@BA@A@AB@@@BB@@B@@@B@@@B@D@B@B@B@B@B@BA@@BA@@@@@@BA@@B@BABAB@BA@@B@B@B@B@@A@@BA@@@@DAB@@@@A@BB@@@B@@@B@B@B@B@B@B@D@@@BB@@B@BAB@BADABADA@@@@B@@@B@@@B@@@BBB@B@@A@@B@@AB@@@@@B@@BD@@BB@@@BABB@@B@B@@@B@BBB@@@@B@@@BB@BB@@BB@@@B@@@@BB@@@@B@@B@@@@BAB@BA@AB@@@@A@A@@@A@@BAB@B@@AB@BAB@@AB@@@B@@@@@BA@A@@BAB@@AB@@@BA@@@@BA@@@@A@AA@@AAA@@A@A@A@C@@BA@ABABAB@BA@@B@B@B@B@@@B@B@B@@BB@B@@BB@@@@@B@@@@@B@@@@@@@@@@@@@BB@@B@@ABBB@@@B@B@@@@@@@B@B@@@@@B@@@@@B@@@@@B@@@@@B@@@@@B@B@B@@@D@B@B@@BB@@@B@B@B@B@@@B@B@B@@@BAB@@@D@@@B@BAB@BA@@BA@@AA@A@@@@D@BAB@B@BAB@B@@A@@B@BAB@@@B@@@B@@@BAB@B@BAB@@BB@@@@@@@BB@@@B@@B@@AB@B@BA@@B@@ABA@@@AB@@AB@@@B@@AB@B@@@BA@@@@BA@A@@B@BA@@BA@@@AB@@@@A@ABA@@BA@@"],"encodeOffsets":[[129105,42539]]}}],"UTF8Encoding":true});}));