(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('临江', {"type":"FeatureCollection","features":[{"type":"Feature","id":"220681","properties":{"name":"临江市","cp":[126.919296,41.810689],"childNum":2},"geometry":{"type":"MultiPolygon","coordinates":[["@@DDDBDBB@@@@@@CA@@AE@AAA@AA@@A@BB"],["@@A@@AA@@@A@@@@B@@@@AB@B@@@@BB@@BBDDBB@@@B@B@@@B@@ABA@CBA@ABAAA@EA@@A@A@E@CAE@C@C@C@C@A@C@CBCBABC@CDADAB@@@B@B@BBD@BB@BBB@B@B@B@DAB@HEBAB@B@D@B@@@BB@DBF@D@B@J@@BB@BBBBB@@BBB@HBD@D@DAB@B@@@BBFBB@@BB@@@@B@B@@CLAB@B@BB@@BDBHFBBB@B@B@B@F@B@FAB@FAB@R@D@B@D@BBBBB@@BBB@B@@@B@B@B@BA@@BCBADA@@@@@@BA@A@@@A@@@A@@@A@@@@@A@@@C@A@@@A@A@KBE@]AG@G@EBE@CBA@CBA@AB@BABAB@B@@@BB@@BB@DBBB@@BB@@@B@@@B@@AFA@@B@B@D@@@BA@@B@BA@ABA@A@A@A@A@A@KEA@AAA@E@A@A@A@GD@@A@EBA@A@@BA@@BAB@@@B@BB@@BRDB@B@BBDDDDBB@B@B@B@B@B@@@BA@CB@@ABAB@@ABA@A@IAA@A@A@EEA@@@A@@@KD@@A@C@A@A@A@@@AB@@@BA@@F@B@BAFADABABA@EDEBC@SFC@CBEBCDGDABAB@BAB@@@BBB@@BBBDJJBBBB@BDL@@@BB@BBB@B@B@B@BAB@@ADA@ABADAB@DAB@B@DBF@DBDBDBDBDDBB@BBB@DBBAB@B@@ABCBC@C@EAUCC@C@CBAB@BAH@D@BBB@B@B@@AH@B@B@@ABAB@@A@@B@@@B@B@F@B@BBHB@BF@B@D@@AB@BABABA@A@@@A@A@A@C@M@C@A@C@AAC@C@E@C@E@EBC@KDABA@ABA@@B@@@@@B@@@@@BBDDDBDB@@B@BAD@@@B@BA@A@AB@@@@AAA@A@A@WDC@C@CBABA@@@@B@BAD@@@BEH@@AB@@A@A@A@G@C@I@IAC@KAA@A@@@AAAAA@A@AAA@ABA@EBA@CDA@AB@BA@@B@BBH@BBB@BBBBBD@B@@@B@B@DAB@B@@@B@B@@BB@DHBB@BBD@D@D@DAB@B@@@B@@ADAB@@A@@BA@@@AB@@A@A@A@@BA@@@C@@@@@A@A@A@ABA@@@A@A@@@AB@@A@C@@@A@A@@@A@@@AAA@A@@AAAA@AAAAA@ACA@@AA@AACAAAAAA@@AA@AACAEAEAGAGAEAA@@@CAAA@@A@@AA@AAAAA@AAAA@AA@@@@@AA@@@@A@AA@A@@A@AA@@@@@@@@@@AA@@@@@@AA@@@@AA@@@@AA@AA@@@AAAA@@@ACC@@AA@@CCA@@A@@AAACAC@AA@@@AC@@A@@A@AAA@CAGACAA@CCC@AAAAE@A@@@A@A@@@A@@@@@A@@@@@A@@AAAAACA@@ACAA@AAC@E@C@ABC@ABABAB@DAB@BENAHADABABCBABA@A@A@AAA@CAA@@AA@CGAAAA@@AA@AA@@AAAAAAAACAAAA@C@AAI@A@CAC@CBA@EBCBCBGDG@A@A@@@AAAACA@AAC@C@C@E@EBCBA@CDABAD@DAD@BBD@B@F@B@B@@@BABABKHIFCDKFCBCBCDCBABCD@@EFCBEDOJGFCBCBCBC@ABC@A@G@EAKAEAA@CACAAACCCEEGAC@C@C@ABCBABADCDAFAFCJAF@FAF@J@BAB@B@@@BA@@@@@@@AA@@@A@@@AA@@@@@@B@HC@AB@@A@ABA@A@@@@@AA@@@@@@@CB@@@@AA@@@@@@@C@@AA@@@AECKGACAAAAACAA@@@@@@A@@@AB@@@@A@@@@A@@@@BA@A@@@A@@@@A@@@EAC@AAA@C@AACAECAAAA@A@AAA@A@A@A@@BABA@@@@@@C@ABIDEDC@@@AB@@ABABCBCB@@A@ABA@A@A@A@A@AA@@ABC@ABA@A@A@ABA@A@@BAB@@ABA@A@A@A@CBABA@EBA@A@@@A@@BABAB@@@BCBAB@BA@@B@BABA@ABEDEBCBCBA@AB@BABBBDDB@@F@B@D@BAB@BA@AB@@CB@@A@A@@@A@@BA@ABABA@CBA@E@A@A@CBA@@@A@AAAB@@A@A@ABA@@BAB@@@BABC@AB@@AB@@A@ADA@@B@@BB@@@D@B@@AB@BDD@BAD@DB@@BBBBJ@@@B@@AD@B@@@BBB@B@BAB@@AD@@@DA@@@@BABABC@AB@B@@@D@BAB@@AB@BA@AB@@AD@B@@CD@B@@@BCBA@@BABABCDEBAB@@@B@BBBBB@B@@@BBB@@@B@@@@BB@@BBBBBB@@@BBBDBBB@@BDBFBF@D@@B@DBFDBBBA@@B@D@B@B@DAB@B@D@B@BAB@B@B@BAB@@ABAB@B@B@B@B@@@B@@@BBBA@B@@B@@@B@D@D@BBD@D@BB@@BB@B@B@B@B@@@BB@@BB@BBB@BB@B@@B@@B@@@B@@BB@BB@B@BBB@BBD@BBD@BBBBDBB@@BBBB@@BB@B@D@B@BAB@@@B@B@BBB@B@B@B@B@@@B@B@BBB@@@BB@@@@@BB@@@B@@@B@D@@BB@BB@BBBB@BDBB@BB@BB@@BB@@BBB@@@B@B@@@B@D@B@B@BBBBBB@BBB@B@B@BB@B@@BB@@B@@BB@B@BB@BB@BBB@BB@@@@BBBB@@BB@@B@@@BBB@@BBB@BBB@DBB@@B@@BB@BB@BB@B@@@B@B@BAB@B@@@B@@@@BB@B@@AB@BABA@@B@@@@B@B@BBB@BBBBB@@B@@B@B@D@BA@@B@@@@@BB@@BB@@B@@@@B@@BB@BBB@BBB@@@B@B@@BB@B@@BBB@BB@B@@@@@@BB@@BBB@BDB@BBDBBB@@B@@BBB@@@@@B@@AB@@AB@BA@@B@@BB@@BBBB@B@B@B@B@B@@@B@@ABA@A@@BA@@BAB@@AB@BAB@@ABA@@BA@B@@@B@B@@@B@@B@@B@B@@@BB@@BBB@@@@@@@B@BB@@@@@B@D@B@@@BBB@@B@@BB@B@@B@@@@@B@BBB@@BB@@@B@A@@B@@@B@B@B@B@AB@B@DB@@BB@@B@@@B@@@BB@@B@@@B@@@@BBB@BB@DA@@B@B@B@@B@@B@@B@@@@@@@B@@@B@BBBAB@B@B@B@BAB@@BB@@@BB@BB@@BB@B@D@B@@B@@@B@@@B@@BBA@B@@B@@BBB@BB@@B@@@B@B@@@B@B@@BB@BBB@BB@@B@B@B@B@@@BBB@DBBBBBB@@@@@BBB@B@@@B@@@B@B@@@B@B@@@B@@@B@BBB@B@B@@AB@B@BA@@@AB@@@@AB@BA@@BA@@@AB@@A@@B@BAB@@@BB@@BB@@BBB@@@@@@@@B@B@@@BB@@@B@B@B@D@BAB@@@B@BBB@B@@@B@@@B@BA@@@ABA@A@@BA@@AA@@AAC@AAA@A@BA@@B@@AB@@A@@@AB@BA@AB@@@@AA@@AA@@A@@@A@@@@@AB@D@B@B@D@B@B@BA@@@A@A@@@@B@@A@@BA@ABABA@@BA@@@AA@AA@@@@B@@@BBB@@@D@@@DBB@BBB@@@B@@@B@B@@ABA@@@ABA@A@@BA@@BAB@BABB@@BBB@B@B@B@D@B@BBB@@@BAB@BAB@B@B@B@@@B@@@B@@@B@@A@A@@@A@@BA@A@@B@BAB@D@BAB@BAB@B@B@BAB@BAB@BAD@BAD@D@D@D@BBB@D@@ABABCBCBABABBBBB@B@B@B@B@B@B@B@@AB@BA@CBABEDC@ABA@@B@@BB@B@B@B@BBB@@@BBBBB@B@@@D@B@@@B@B@BB@@@BB@@B@@BB@@D@@@BBBBBBBBBB@BB@BBBBBB@@BBD@BBB@B@@@BB@@@B@@@B@B@@AB@@@@@@@@@@@B@@@@AB@@@@@@@@ABABA@A@A@@@A@@AABA@@@@@@BA@@@@@A@@B@@@@@@A@@B@@@B@@@@@@@@@BA@@@@BBB@B@@BBA@@B@BA@BB@@@B@B@B@BB@@@BBB@DBB@@@BBB@@BB@B@@BB@BBB@B@@@BBBB@@@B@B@@@@BBB@BBB@@@@@B@B@@BBB@B@@BBB@@B@BB@@B@B@B@B@@@B@@@BBB@B@B@B@@B@B@B@B@@BB@@@@@BB@@B@@@BB@@@@B@@BB@@ABA@@B@@@@@BB@@@@@@B@@@B@@@D@@@BAB@@@B@BAB@@@B@BA@@BAB@@A@A@@@A@A@@@@@A@@@AB@@A@@B@BAB@B@B@BBB@@@BBB@B@BBB@B@BBB@@BB@B@BAB@B@B@@AB@@@B@B@@@B@@@B@B@@B@@B@BAB@@@B@B@BAD@@A@@CA@@AA@@@A@A@@B@@A@BB@B@@@B@@AB@B@@AB@B@B@B@@@B@B@@AB@B@@@BAB@@@B@@@B@BAB@@@BAB@B@BAB@@@B@@@@@B@@BB@@@BAB@@@B@@B@@BAB@D@BAB@B@B@BBBAB@@AB@BABABAD@BAB@B@BB@BB@BBBBB@@B@@@BBB@B@@B@@@@BB@@BB@B@@BB@@@B@BA@@BAB@@A@@@@BB@@BBD@B@D@D@B@B@B@@BB@@@BA@@DA@@B@BA@@B@D@D@B@@@B@DD@B@@@BBB@@BBB@@BBB@B@@@@BB@@@@@@BB@@B@B@@BD@B@B@BAB@BB@@BBB@@BB@B@B@B@@@BB@BBBB@BB@BBBAB@B@B@@ABB@@@BB@@@BA@@BABA@@B@@B@D@BBB@B@@@B@B@@@BAD@BBDA@@D@BAB@D@B@DBB@B@D@B@@@B@DBF@BBB@BBB@@BA@@BA@@@@@@@@B@@@B@@@@BB@BB@BB@BBBA@BBA@@@@@@@AB@@@@@BA@@@@B@@A@@B@@@@A@@@@BAB@@AB@@B@@B@@BBBBB@BBBBD@@BB@B@D@B@@@BB@B@BB@@BB@@BB@BBB@@@D@@@D@@@BBB@BBBBBDBBBDBBBBBB@@B@@BJ@H@D@B@BBB@B@@@B@B@D@BAB@D@B@B@@AB@@@B@B@D@D@B@D@BAD@D@H@HAF@F@D@@@B@@A@A@C@ABA@A@@BADAB@F@B@F@DB@BB@BAB@DADADADAHADAHAF@D@FADAD@B@D@DAF@D@D@FAD@FBD@D@D@DADAD@D@JAFAF@DAHAF@F@FAD@DAB@D@B@B@D@F@D@F@@@FAF@HBD@FAD@D@D@B@D@D@DAD@B@B@BCBAFA@ABADABA@ABA@ABABABABABA@ABABA@CB@@ABA@ABC@CBC@@@A@A@A@@@@BA@@BA@A@@BA@C@@@ABAB@B@BA@ABADG@A@A@@@AAAAAA@@AAA@C@@@ABC@@BA@A@@ACAA@AA@@@AA@@@A@A@CBC@C@CBA@CAA@AA@BA@@AACACAA@@A@@@A@ABE@A@A@CBA@ABABCDC@@BABA@@BADA@@BABA@A@A@AAA@A@A@AAA@AAAA@AA@A@AAA@@@@AAA@A@A@AA@@@CAA@AB@@AA@@AA@AAAAAA@@@@@A@A@A@ABADABAD@@A@@@AACAC@AAA@ABADAFAHADADAFAFAFAFCDABABADCBADC@A@A@@@@B@@@@@B@@@@@@@@@@@B@@@B@@A@@B@@@@@@@BB@@B@@@@@B@@@B@@@B@@@@@@B@@B@@@B@@@@@B@@@@@@@@@@@B@@@@@@AB@@@@@@@B@@A@@@@B@@@@@@@B@@@@@@@@@B@@@@@@@B@@@@B@@@@B@@@@@@@@@@@B@@@@@@@B@@@@AB@@@@@B@@A@@B@@@B@@@@@@A@@B@@@@@@@@@B@@@@@@@B@@@B@@@@@B@@@B@@@@@B@@@@@@@B@B@D@BAB@FAD@D@DAD@B@B@@@BBB@B@FBB@B@D@B@DABBF@D@D@F@D@DA@@B@@A@@@@@AB@F@@@@AB@@AA@@AA@AAA@A@@@A@@@@@AA@@B@@@BAB@@@B@B@B@@@B@B@@@B@@A@@@@@A@@@@@A@@@@@A@@@@@A@@@@@A@@@A@@@@B@@AB@B@@@@BB@@@@B@@@@BB@@@@@@B@@B@@@@B@@@B@@@B@@AB@BA@@@@@@@A@@@@@@AA@@AA@@@@@@B@@@@@BA@@@@@@@@@@@@@@BB@@@@B@@@@@BAB@BAB@@@BA@@BA@ABA@@B@@AA@@@A@C@A@@@@@@@A@A@@AA@AA@@A@@A@@A@@@@@AA@@@@@@@A@@@@@@B@@@BB@@B@B@B@B@@@BA@@B@@A@@@AAA@C@@@@@A@@@@@@@@@A@@@@@AAA@@@@@@BA@@@@B@A@@@@@@A@@@@B@@A@@@@@@@@@A@@@@@AB@@@@AB@@ABA@AAA@CAAAA@@AAA@AA@@@AB@DAFCDAHADAB@B@DAD@B@B@@A@A@ABCBABABAB@DA@@BA@AB@BAB@B@B@BAB@B@B@B@BBFBFDBBDBBBB@B@B@B@BCDADAB@D@D@DBD@D@DAFAB@FCDCDADGFEDEDCBABADAFAHADAF@DAF@J@D@BAB@BAFAHCJCFAFCHADAB@B@D@B@B@DADAD@BAD@F@@BB@D@DBBB@@B@@ADCDCBCBAB@DADAFAHCHADADADAB@D@B@B@B@B@BBB@B@BAF@DAB@D@@@BBD@D@F@B@B@@@@ABCBC@AA@AC@AAA@C@@BA@ABADCDAFEBABAFCBADAAA@@CA@AAAACAAAAAACCAAAAA@@AE@AAA@A@CAA@A@G@C@E@C@EAC@C@AAC@AACAAA@@@@@@@@A@@@@@@@@@@AA@@@@@@@A@@@@@@@@A@@@@@@@@@AA@@@@@@@A@@A@@@@@@A@@@@@A@@@@@@@A@@@A@@@AAA@E@@AA@A@A@AAA@AACCAAAAA@CACAA@@AA@A@AA@@A@@@AACAA@C@@AA@@@@@A@@AA@@@@AA@A@@@C@CBE@CBC@A@A@@@A@@@A@AAA@@@A@@@A@A@@@A@A@@@AB@@A@A@I@AA@@A@A@ABC@@@A@A@@@A@@@A@A@@@A@ABA@C@@BA@@@A@@AABA@@@@@A@@@@@A@AA@@A@@@A@EAA@A@AA@@A@C@CBA@A@A@@BA@A@A@A@C@@@A@A@A@A@E@C@C@A@C@C@A@C@ABA@@@ABA@@B@@A@A@EAA@A@AACAAAC@A@AAC@A@ABCBC@C@AA@@AAA@@AAAAA@AAA@@AA@ACA@@AA@@AAA@@@A@@AA@A@@@A@CA@@AA@@A@@@A@@@C@CACA@A@@A@@A@@AB@@CA@BA@A@A@@@A@@@@@@@A@@@@@B@@@@AA@@@@@A@@@@@AA@@@@@@@@@@A@@@@@@@@@@A@@A@@@@@@@AA@@@@@@@A@@A@@@@@@@@B@@@@A@@@@@A@AB@@ABA@A@@@@@@B@@@@A@@B@@A@@@A@@@AA@@A@@@@@@BA@A@@BA@C@A@A@@@@@AB@@@@A@@AA@@@@A@@A@@@@@@@A@@AA@@B@@@@A@@@@@A@@BA@@@@B@@A@@BA@@@@B@@@@@@A@@@@@A@@@@@@@A@@@@@@@@@AB@@@BA@@@@@A@@@@@@@A@@@@@A@@A@@@@@@@AA@@@@@A@A@AAA@@@@@@AA@@A@@@@@AA@@@@@AA@@@@@@@A@@A@@A@@A@@@A@@@@AA@@@@@@@A@@@@@A@@@@@A@@@@B@@E@@@A@@@A@A@AAA@A@@@A@A@@@@@@@A@@@@@@@@B@B@B@@@B@@ABA@@@ABA@@@AA@@A@AAAAA@@AA@A@@@A@A@A@AA@AA@CA@AA@@@A@@@@AA@@A@@A@@A@@@AAAAAAA@@A@A@A@A@ABA@@@A@@BA@@@AB@@A@@BA@A@A@@@@AA@AAAAA@@AA@@@A@AAC@A@A@A@A@AB@@AB@B@@ABA@@@A@A@AAA@@A@A@@@@@A@@B@B@DCBABA@A@@@AA@@AA@AAA@C@C@A@@@A@@@E@@@A@@@AA@@@AA@@AA@A@@@A@A@@@A@CAC@@A@@A@B@@A@@BAB@BAB@B@@BBAB@B@BA@@B@@@@AA@@@A@AAA@A@@@@@AB@@ABA@@@A@@@A@AAA@AAA@A@C@A@A@@A@@@A@@A@A@A@@@ABA@AA@@A@@B@@@@@B@B@BA@ABA@AB@@@@@@A@@BA@@@@@A@@A@@BA@@@A@@@A@@A@A@AA@@A@@@C@AAAAA@A@A@A@A@@@A@@@A@@@A@AA@@A@@@ABA@@@A@A@@@ABA@@BA@@BA@A@A@@A@@@@@AA@@AA@CA@@A@@@A@A@AA@@AA@@@AA@@@@A@@A@A@A@A@C@A@ABA@A@A@@AA@@@AC@@@@A@@@C@A@A@AAA@@A@@AA@@@ABA@@@A@@@A@@A@@AA@@AA@@A@@A@@AA@@AA@@@A@@@A@@BA@@@AA@@A@@@A@A@A@@A@@@AA@@A@A@A@@A@@@@@AAA@A@@AA@@@A@@@A@A@E@A@CAA@C@AAA@@AACAAAA@@AAA@AAA@A@@@A@A@ABA@@@A@A@@@A@@AA@A@A@ABA@AB@BA@ABA@A@A@@@A@AA@@CAA@@AA@@A@@@@AA@A@A@@@@AAAAA@@AA@@AC@AAA@@@@A@@@@A@@@@AAE@@@@AA@@C@CAAAA@CAAAA@@AA@CAA@@AA@AA@@@A@A@A@@@AA@AA@AA@A@@@AAA@A@@@@A@@AA@AA@@A@@B@@@@AB@@AB@B@B@B@@AB@@@@A@@@@@AA@@@A@@@AACA@@@@A@A@A@A@@@A@ABA@A@A@A@@@AAA@@AA@BA@@@@@AB@@@@A@@BABA@A@@BA@@@@@AA@A@AAA@@@A@@@@@A@C@AB@@A@@@AB@@@@BB@@@@@@ABA@A@@@A@A@@@AA@A@@ACA@@AA@@@@BA@@B@@@B@@@@A@@@ABAAA@A@@@@A@@@CAA@@@@@@@@@@A@@BA@@@@@A@A@@@@A@A@@@A@@@@@A@@A@A@A@@@A@@@@@@@A@@@ABA@A@@@AAA@AAA@@ABA@CBC@@@AA@A@@@A@A@CAA@@BA@BD@B@@@B@B@@A@@BA@CBA@C@G@A@@AA@ECAAAACACAC@A@C@C@GBC@A@ABAB@@AD@B@BAF@DAB@BA@ABC@E@C@A@A@AACAMKA@AAA@CAA@CACA"]],"encodeOffsets":[[[129967,42811]],[[130196,42528]]]}}],"UTF8Encoding":true});}));