(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('新宾满族自治县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"210422","properties":{"name":"新宾满族自治县","cp":[125.037547,41.732456],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@@@A@A@E@I@@BE@E@@@@@ABAAA@A@CA@@A@CBA@@@A@@@A@@@A@A@AAC@@@A@@AA@AA@@@@A@@@A@A@@AA@A@A@A@EA@@AA@A@A@@@A@A@@@@@@AA@@B@@@@@@@@A@@@@@@@@@@@@@A@@@@@@@@A@@@@@@@@@@@@A@@@@A@@@@@@@@@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@A@@@@@@@@@@@@@A@@@@@@@@@@@@@A@@@@@@@@@A@@B@@@@@@@@A@@@@@@@@@@@A@@@@@@B@@A@@@@@@@AA@@@@A@@@@@A@@@@A@@@@A@@@@AA@@@@@@@A@@@@@@@@B@@A@@@A@A@@@@@@@@@A@@@@@A@@@@@@@@AA@@@@@@@@@A@@@@A@@A@@@@A@@@@@AA@@A@AA@@@@@@@A@A@@@@@@@@@A@@A@@@@A@@@@A@@@@@@@@A@@@@@A@@@@@AB@@@@@@@@@@A@@@@@@A@@@@@@@@@@@@A@@@@@@@@@@@A@@@@@@@@@@@@@@@@@A@@@@A@@@@@@@@A@@B@@@@@@@@@@@@@@@@@@A@@BB@A@@@@@@@@@@@@AA@@@@@@@A@@@@@A@@@@BA@@BA@@@@B@@@@A@@@@@@@@@@@@@@@AA@@@@A@@@@@@@@BA@@@@B@@@BA@@@@@@A@@A@@@@B@@@@@@AA@@@@A@@@@A@@@@@@@@AA@@@@@BA@@@@@@@@@@A@@AA@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@A@@@@@@@@B@@@@A@@@@@@@@@@A@@A@@@@@A@@@@@AB@@@@@@@B@@@@@@@@@@@@@AA@B@@@AA@@A@@@@@@@@A@@@@A@@A@@@@@A@@@A@@@@A@@@@A@@@@@@@@AA@@@@@@@@@@A@@B@@@@@@@@@@@@@@A@@@@@@@A@@@@@A@@A@@@@@@@@@@A@@@@@A@@@@@A@@@@BA@@@@@@A@@@@A@@@@B@@@@A@@@@B@@@@@@@@AA@@A@@@@@A@@@@@@@@@@@@B@@@@@@@@@AA@@@@@@@@DC@@@@@@B@@@@@@@B@@@@@A@@A@@@@@@@@@@@@AA@@A@@@@A@@@@@@@@@@BA@A@@B@A@@@@A@@@@@A@@@A@@@A@@@A@@BA@@@@@A@@@@A@@A@@@@@@@AB@@@@@@A@@@@@@B@@A@@@@@@@@@@@@B@@A@@@@@@@@BA@@@@@A@@@@@A@@@@B@@@@A@@@@@A@@@@@@@@@A@@B@@A@@@@@@@@@@@@@@BA@@@@@@@@@A@A@@B@@@@A@@@@@@@A@@@@@A@@BA@@@@@@@@@A@@B@@A@@@@@@BA@@@A@@@@@@@AB@@@@@B@@AB@B@@@B@B@BA@@B@@@@A@@@@BA@@@@@@@@B@@@@AB@@@@@@@@A@@@A@@@@B@@@@A@@@@B@@A@@@@@A@@@@@A@@@@@@@@@A@@@@A@@@@A@@B@@@@@@A@@@@@@@A@@@@@@@@@@A@@@@A@@@@@@@@@A@@@@@@@@B@@@@@BA@@@@@@@@@@@A@@@@B@@@@@@A@@B@@@@@@@@@AA@@@@@@@@@@@AB@@@@@@@A@@@@@@@@@@A@@@@@@@@@@@@@@B@@@@@@A@@@@@@@@A@@@@@@@@@@A@@@@@@@@@@@@@@AB@@@@@A@@@@@@@@@@BA@@@@@@@@B@@@@@@A@@@@A@@@@@@@@@@@@@@@@@BA@@@@@@@A@@@@@@@A@@A@@@@@B@@@@@B@@@@@B@@A@@B@@@@@@@@@@@@@@@@@B@@@@A@@B@@@@@@@B@@@@B@@B@@@@A@@@@@@@@B@@@@@@@@@B@@@@@@@B@@@@@@@B@@@B@@@@@@@@@@@BB@@@@@@@@@@B@@AB@@@@@@@@A@@@@@A@@@@@@@@B@@@@@@@@@@@@A@@@@@@@@@@@@B@@@@@BA@@@@@@BB@@@@@@@@@@@A@@BA@@B@B@@@B@@@@A@@@@B@@@@@@@B@@@@A@@B@@A@@@@@@@A@@AAA@@@A@@@@@@@A@@@@A@BA@@A@@A@@@@@AA@@@@@@A@@@@AA@@@@@@AA@@@A@@AA@@AA@@AA@@@@A@@@AB@@A@@B@@A@@@@@AB@@@@@@@@@@@@@A@@A@@@@A@@@@@@@@A@@B@@A@@@@@@@AB@@@B@@A@@B@@@BA@@@@@@@@@@@A@@@@@@@AA@@@@@AAACAA@A@@A@@AA@AA@AA@@A@@BA@A@@@A@A@A@ABA@AB@@A@@BA@A@@@A@A@A@@@A@A@@AA@@@AA@@A@A@AECAECCACAA@A@AB@@A@C@@@A@@AA@@@A@AA@@A@AAAAAAAAC@@AA@A@@@A@A@@@A@@@A@@@AA@@@@AA@@@@A@@@@BA@@@@@AB@@@@ABA@AB@@A@@B@@@@@B@@@B@@@@@@@BA@@@@@@B@@@BBB@@BB@BB@B@@B@@@@@B@@@D@@AB@B@@@@@B@B@@@B@@@B@@@@@B@@@@@B@@@BA@@B@@@B@@@@@BB@BBB@@@BBB@@BBB@@@B@BB@@BAB@BBB@@@B@B@@@B@B@@@B@@@B@@@BA@@@AB@@@@@B@@BB@DBB@BBB@@@@BB@@@@B@@B@@BB@B@@@BB@BB@@BB@@B@@B@B@@@B@@@BBB@@@B@@@B@B@BAD@@@B@D@B@B@B@@BB@@@@@B@@B@@@BB@B@B@DBB@@@@AB@B@B@BA@@BBB@BBB@B@BB@@B@@@BA@@@AB@@AB@@AB@@@BABAB@@AB@@AB@BA@@@@BA@@@AB@@AB@@@BA@@B@@@@AB@@@@AB@@@BAB@B@@@BA@@@A@@B@@@BBB@B@@@B@@@B@@@B@B@B@B@@AB@BBB@B@B@@B@@BA@@B@BA@@B@@A@@@AA@@@@A@A@@@A@@@@BA@@@@@A@@@A@@@A@@BA@@B@B@B@@@BA@@BA@@@A@@AA@@AA@@A@AA@@AA@@@@@A@@B@@AB@@A@@BA@@@A@A@@@A@@@A@@B@@AB@@AB@@A@@B@@A@A@@BA@A@@@@@@B@@AB@D@B@B@DAB@B@BA@@@@@AB@AA@AAA@A@@AA@@@@@@@A@@@AA@@AA@A@@AA@@AA@@A@@AA@@A@@AA@@AA@AA@@AAC@@AA@@AA@@A@A@AB@@A@A@@AA@A@A@@AA@@A@@AA@@@@@@A@@BA@AB@@A@@@A@@A@@AA@@A@@A@@A@A@A@@@A@@@A@A@@@AB@@AB@@@@A@@@AB@@A@A@A@@@A@@B@@AB@@A@@@@@@@AB@B@@@@ABAB@@ABA@@BADA@@BA@@@AB@@AA@@AAA@AAC@@AA@@@A@AB@@A@AB@@A@@@AA@@@@AAA@@AA@AAAA@@A@A@@@@@A@@@A@@A@@A@@@A@@@@@A@@@A@@@AAA@@@A@@AAA@AAA@A@ABA@A@@AA@C@A@A@AB@@@@A@EAOBGAIEGEE@]FMPKHKFEAAGGIAAAOGIICQIIKUSKCGE@CAIEICEWEQ@KAKBKBG@@@C@A@ABCBA@A@AB@@@@A@AB@@CA@@ADGFA@CDA@ABC@@A@A@C@@@@CC@@A@@@AA@@AA@A@@A@BC@@A@@A@@@AAABA@@AG@@CBA@@@AA@AA@CAEAAAA@C@@@CBA@@@@@CAA@A@@A@@CAA@A@EA@@A@AB@B@@@BA@A@@@A@AA@@AB@@A@AACBC@A@@@@B@B@BA@ABB@@B@@BB@@@@@BA@A@ABABAB@@@B@@BBADADA@@B@B@@@@ABA@@@C@AAC@@@@A@A@AAAA@A@A@C@AAA@A@A@AAC@AAA@A@A@CAA@BCACACAAA@IBYDWLIHKFGBI@WEMGOCI@K@GBQ@KA@IBI@G@ECES@WJIDOHGDSFGFIDKBKDSAYHKBIJKJERIEGIGIGEQCI@AAE@AAA@@AAA@@A@A@AA@@BA@CAA@ACACAA@AA@@@AAA@@EC@A@@AA@@@AAA@ABAAA@@AA@AC@@A@@@AEAA@A@@@A@A@C@AAA@E@A@A@A@@@A@A@EE@@@@@AB@@ADCBAB@BC@A@A@A@@@AB@@A@@@@BAB@@A@@A@AAAA@AA@@AACAC@@AA@C@AA@A@@@A@AAA@ABC@A@A@ABABA@AAAA@@AAC@AA@@@C@@@@@A@AACAA@AAA@@B@@ADA@@AA@@DA@@@A@@@@@@AAA@@A@A@@A@A@AA@@EB@@A@AA@@@@AEAC@@B@@ADCBAB@AC@C@A@@@@@ABABADE@A@ABA@A@@BA@@@A@@A@EE@@A@A@@@@A@@@C@A@@@CA@@A@ABA@@BAD@@@@A@@@@@A@@@A@AAAAA@AAC@@@A@A@@@AAC@@B@BAB@B@BAD@BA@@D@BA@@DA@@@A@AA@@ACAA@@@@A@CAAB@BABCB@@A@@@ABA@@BA@AB@B@DBB@@AB@@@@A@@AA@@@CA@@@AAA@@@@CAA@AAC@@@CAC@CAA@@@A@A@@BABCB@B@@@@ABC@@@@AAA@@@CAA@EAA@@@A@E@A@A@@@AAA@AB@@SCIACKGKKEWI[GUIOGOOMGMEICWA[EOCYIS@SBQDM@KSMKGEEEGGIAKJCBCL@HBLMHUBI@Q@M@MDUTOJSJQTKPKJGFIBMB[JQNOLYHWCIAMGIECMBCB@@@BCHIDE@CGCWAWD]PCDAJANCHIRQDMDGDCJELA^EBOFQHONMPKPEP@XAFDNJLNNVPTLLLJCLBLALAXGLPHPJNNJDNBHEFGJCLHNPREHIHKLGLJJHBNDLDBH@LWJQLIJGJGLQFMAKBEHCLAL@LPPRHPJTHJNFLFJDHEJILGD@@AB@D@@@B@@DBBBD@D@B@@BBDF@BBBB@@D@D@BB@@ABABAF@B@@@@BBBBA@@BB@B@D@F@B@D@B@BBEF@B@@A@@B@BBD@@@@@BAB@@@B@@@@BB@@BB@B@B@@ABA@@BA@ABA@EACA@@CAA@@AABA@@B@@AB@@@@C@@@C@ABA@AAA@EAC@@@@BA@@BAB@BBBAB@@ABC@C@A@@@@B@@CB@@AB@BA@@@A@@@A@A@@BADCB@BABCB@@@@BB@BA@@B@B@@@B@@@B@@@@@@BB@@@B@@BB@B@@@@AB@@@@AB@BABABA@@@BBB@BB@B@B@DD@@@B@@BB@D@BB@@@@DB@BB@D@@@@D@B@@B@B@B@B@@@B@@@BBB@BAB@@@@BB@BBBBB@BBBBB@@@BB@@B@@ABBD@@BBBB@BBB@DBD@BBB@BB@AB@@BB@@@@B@@AB@@@B@B@@@@A@@@CB@BAB@@A@@@@B@@C@AB@B@@@@BBAB@@@D@@ABABBB@@@DAB@B@B@D@@ABA@@@A@A@@@ABC@@@C@CBA@@BBBA@@B@B@@A@@@@BBB@BB@@B@@@@@BABA@@BAB@@A@A@AB@@ABBBDD@@B@DAD@B@B@FDDD@B@@ED@@@@@BAD@@@BB@BBB@@BB@D@B@@BB@@BA@@BBB@@@B@@@BADA@@B@@BBBB@B@B@BBBB@@BBBBB@@B@@BBBBBB@@B@B@BCD@@AB@@@BAB@@BB@@@BAB@@@B@@BBA@@B@B@@A@A@@@E@@@CA@B@@@@A@@@AFA@@@@AA@AC@@AB@@A@@AAA@@@@C@@AA@@AA@@A@@@@AAA@@@AA@AEAA@@@ABABAB@@@B@B@B@B@BA@A@@B@BABABC@@@@CCA@@C@G@A@A@@@A@@@A@CDE@@@A@@AA@@A@A@@AAEAA@ABC@EBA@@@A@@AA@AA@@AA@@BA@A@@A@@A@@CA@@@A@@C@A@AA@@A@@@@@@AA@@@AACBA@@@@@A@@@CD@@AB@@AB@@A@AB@@AB@@A@A@E@A@@BABA@@@@BA@@B@@@B@B@@@B@@@BC@@BA@@@@D@BBB@@A@@BBBB@B@B@DBBA@@@BBBB@B@@@@DB@@H@B@@@@@@BBAB@BBB@@@@@B@B@B@@ABB@@B@@DB@@A@@@AB@BA@@@@BB@@@@B@@ABBB@@B@BB@BB@@B@BB@@BB@@@ABB@B@@@@B@B@@B@@@B@@BB@ADDBBBD@B@D@D@D@D@B@F@B@B@@BB@BB@@@BAB@@ABA@A@@@@@@BC@A@AAE@A@AB@@A@A@@@@@@@A@@@@@@B@BA@@@BB@@@@A@@@@B@@BB@@@@A@A@@@@@@AB@@@@@A@@@@@A@@@@B@@@@AA@@A@A@A@@BAA@@C@@@AB@@BB@@A@A@@@A@@@@BA@@@AAA@@@A@@@@@@@@@@@@@@@A@@@@@@@@B@@@@@@A@BA@@@@AA@@@@@@@B@@@@A@@@@@A@A@@@@@@@@@ABC@@@@@@A@@A@@@ABAB@B@@BB@@@@@BA@@@A@@@@@@B@@@@@B@@@@B@@@@B@@@B@@AAA@AA@@@A@@@@AB@C@@A@@@CBA@@@E@A@A@@@A@@BB@A@@B@@B@BB@@DB@B@@A@A@ABA@@@B@@@@BABA@@@B@@BB@@@BB@@@@@B@@A@@@AA@@@B@@@@AA@@A@@A@@A@@@BB@@BB@@@BA@@@@@@@A@A@A@AA@@AA@@A@@@AA@@A@A@@BC@A@A@A@@BC@A@A@@@@B@@BBB@B@B@@@@@DBDD@B@D@@BB@B@B@BBB@@@B@@@@D@@@@@@BAAA@AB@@@@@BBBFBBB@@@BB@@@BA@@B@D@B@BA@@B@B@B@DAB@@A@AB@BAB@@@B@B@BABBBA@@B@A@BAACBA@@@@F@B@@@@B@@B@DABBF@B@BAB@BA@@@@@AA@@AA@B@@ABA@@F@@@ABB@B@@B@@DBB@BDB@@BB@DA@ABA@@B@B@@@B@D@B@B@@@@B@BBB@@@@B@BB@@B@@@BBBA@@@BBB@@@BD@@@BAD@BA@@B@@@F@@@B@B@D@@@B@D@BB@@@@AD@B@@CBA@BD@@@B@@BBDB@@@D@@@B@BBBA@CBAAAB@@@@A@@@AB@@A@A@@@BBA@@BAB@BADA@@BBBB@@BA@A@@B@@@@A@@B@BA@@@C@@@AB@@B@@B@@ADABB@F@@BBBBBB@B@@B@BCDBBD@D@@@@@D@HB@@ABA@@@@B@@DACH@@@@B@BABAD@B@@@@BB@@B@@B@F@B@BA@@@@@GB@BAB@@BBBB@@F@@F@B@D@@B@ADBB@B@@AA@A@A@AA@@BC@@@AB@B@BBFAB@@@BBD@@@BB@@B@B@@B@@DABBD@@@@A@@B@D@B@B@D@@A@A@@@@@@B@B@DB@@@@DAB@D@B@@@BBBC@A@@@A@AB@B@@@@A@ABAB@BA@@B@@@BABA@@@@DA@@@AB@@@D@B@B@B@B@@@B@BA@AAA@AAA@AB@@AD@BA@@BCDC@A@C@@DAB@BABAAC@@@C@@@@@@@A@A@A@@BAB@@C@CAA@@BAB@BABABA@ABCA@@A@@BAB@@CBA@@BC@A@A@@A@AAA@CAAA@@AAAA@@@A@@@@@AD@@@B@@@FB@ABA@ADABA@AB@@@B@DD@@B@@AD@D@@AB@BCD@BAB@@BB@B@B@@@B@BA@AB@@@AA@@@A@@@A@@AA@A@@@@BAB@BA@ADAB@B@@AD@@A@@@A@A@ABCBAB@B@@C@@D@B@BBB@@@B@@@BA@ABAB@B@D@@@DA@ARC^CPCVC\\I\\ATDPHZFVAP@NBNDF@RBNK@KEGGEGGEKPEJCJCBCBMDW@KNGJEPE^GXCJ@LBJBJFJFVLFB@@@B@@@@BB@@BB@B@@B@BB@BBBB@@B@@@@AB@@B@@@BBBB@@BBB@BD@@@@BB@@@@AB@BB@@BBAB@D@@@BA@@H@@@B@@@AA@@@@FAB@@@B@B@F@B@B@@@BC@C@A@AB@BA@@@A@@B@DB@@BB@BD@@B@B@@B@B@BAF@@@HBBBB@@BBBBB@@DBDDBB@BB@@@HBHBLARGTARBJ@J@H@LQVEXFZFVDRJLHJFFCDIJAFA^@PHNJJHFDFDJBTGJAL@JBJBDBNHR@N@L@LBJDTNTJLFHHDDBHNPLALANCHAFBHBHDLHJNRJPLNFPNLJJFJHVFJB@@@@B@@AB@@@B@@@B@@@BA@@B@@@B@@@@@@B@@B@B@@@@B@@B@@@@BB@@@D@@BBBBBB@BBB@DB@@F@B@BBDBBB@@DBBDD@B@@BBBB@JF@BB@BBBB@B@@@BB@BBB@@BB@AA@@F@B@HABADC@@B@DBB@D@B@BAA@B@@ADE@@BCBABABABAD@B@B@FAB@DAB@B@@@@@BADAB@FAJ@B@D@D@@@DAB@BCBA@AB@AA@A@@@A@ABABC"],"encodeOffsets":[[128361,42935]]}}],"UTF8Encoding":true});}));