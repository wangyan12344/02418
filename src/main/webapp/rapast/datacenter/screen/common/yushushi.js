(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('榆树', {"type":"FeatureCollection","features":[{"type":"Feature","id":"220182","properties":{"name":"榆树市","cp":[126.550107,44.827642],"childNum":10},"geometry":{"type":"MultiPolygon","coordinates":[["@@@FCHBBCDABABAB@@@BB@EDA@CB@@AB@BDBBD@BBB@@B@@@BAB@@@B@@@@@B@@@@BA@@@BB@BBDBBA@ABA@@@@BBD@B@@BDBBBB@B@D@BA@ABA@ABA@A@@@@@@BDDBD@BBADAB@B@@@@@@@@B@B@@@@@D@B@@B@@B@@HRG@@@A@@@@AAAAC@@A@@@@@@D@@BB@DC@@AA@@CA@AA@@ABCBA@ABA@@@@BBJBD@F@B@BBD@@BBBAD@JABBBDBDBDBB@B@B@@BB@B@B@BB@D@D@@DBD@@ABBD@BC@@@@A@AA@@@AA@@A@@B@@@B@D@B@B@DBDBH@DBHBF@@H@DAB@D@D@FAFAD@BA@@F@BAB@B@@@@@B@DCD@BA@@B@B@DABABA@@@@@B@@@BBF@@BBBHBF@BBB@DBJ@BAD@BFBB@@@@JBB@@@@B@@@B@F@F@F@F@B@BBB@B@B@D@D@D@B@D@@@D@FBD@F@B@BB@@@A@CAK@G@IAE@C@A@A@A@@B@@@B@BBB@@BB@@BB@@@B@BBB@@AB@B@@A@@BAB@B@FAD@B@@@@B@@BB@@@@@B@@A@@@@@@B@@@B@B@@B@@BB@@@@@@@@B@@@@@@@B@@@@B@@B@@@B@@@@B@DADAD@FADA@@B@B@@@D@B@@@B@@B@@ABB@BBBBB@BBB@@BDB@@BB@@@BAB@D@B@B@@@BB@@@@@BB@D@B@@A@@AAA@A@@A@AB@@@B@DC@@@@@BB@@AB@B@@ADA@@@@@AB@@AAAB@@@@AB@@@@@B@DA@A@@BA@EAE@A@A@@@AB@@AB@BBD@F@D@B@B@@AB@@A@A@A@@@@BA@@@@A@@A@@BAB@@A@@@A@A@@@A@@@@@A@@@CA@@@BA@@@@@@@@@@@BB@@@@@@ABAB@@A@ABAB@B@@ABABED@@@BAD@D@@A@@@BB@@@D@@A@@@AD@B@B@@@F@D@D@@BB@@BBDBB@B@B@BBB@@BB@B@B@B@B@BBB@@@BA@@B@BBBBB@BDD@BBBB@@BBD@@B@@B@@@B@B@DBB@@@@B@B@BF@FDFBB@@@BD@@@@AB@B@@@B@@BB@BA@@B@DBB@BD@BD@@@B@@@@B@AB@@A@ABB@A@@B@@@BA@@BAB@@BBAB@B@B@@BB@@@B@@ADB@@@@B@BB@@B@BA@@@EDGBCBCBAB@@BD@BADADABAB@BA@B@@B@@@B@@B@@@BBABB@@B@@@BB@@BB@@@BBC@ABB@@B@BA@@@B@BBA@A@@BB@BB@BB@@@A@BB@@@BA@@@BBA@B@@B@@@B@@@@B@@B@B@@B@B@@B@@A@ABB@@@@@C@@BA@AB@@BBA@@D@@@B@BCF@BB@BB@@A@@B@@@@B@B@@B@@@BA@@@AB@BA@A@@BDBFD@@FD@@@@B@DD@@DB@@D@BBB@BDBDBBB@D@@@@@@B@@ABA@AB@@AD@BA@ADA@@@C@@@@B@BA@AB@@AB@@@FDDADCD@@A@@@@@AA@@@@A@@@@@A@@A@@AB@@@@@@@@@@A@@@@B@@A@@@@@@@@A@@@@AB@@@@A@@@AB@B@B@BADAB@BA@@B@BABA@DDBDADCF@DDBD@JAFABBDFDHFFDBBABABAAA@A@ABAB@F@DFFBDBDADCBEDAHADBBBDFBDDBD@FADCDEBC@EAA@ABAD@B@FBDDBBD@DAD@D@BBBB@@@B@BCBAB@B@B@@BBBBHAFADBF@DD@@@BABCBCBAD@HFFHDJABAHCDAB@HAF@JBDBBDABIDCBEBAB@DBBFBD@H@FD@DCFED@FBDFDDBFAFCDC@CAE@CBCDAF@HFFBDADADAD@D@BD@DBBBBLDBBFFDDD@D@BABCBC@ADCD@H@FBHDDDBHBDBDBBNBHBBBBBBF@BFDNJFDHDDBBDHDHDTFDDDHDBFBFBDAD@BA@C@ABA@ABADEFAJ@D@F@B@D@DBBBBDBDFJDBD@D@DCB@D@F@DBJBFBDBJ@HBBDDBD@F@FADAF@F@BBBD@DDDDBFBFALEHEFAFCDAHBDBDDDHFDBD@@BB@BF@D@D@DBD@D@F@D@DADADAD@B@B@B@BAFADAHAB@FAB@DAFIDAB@D@B@DAB@D@F@BAD@B@B@BA@A@CBAB@DA@@BABC@AB@DADAF@JBD@DABCAAAAGCCA@C@ABA@@B@HABAB@D@BCB@DABAF@DADCBEBCBADADABAD@HBD@BAB@BABA@@BCBADCBAB@BADBB@BAB@B@B@FBBAB@FAF@HBFBDBBAF@B@D@B@LBDADABA@C@CAC@A@ABAFAHAHBJBJBF@DAF@HCJMDETGHABCBA@C@CBEAI@ABABCBC@CBABCD@D@FDFDF@FADADAB@BBFBBBFLBBDBDBHADABA@E@KDEDAF@BBDBHFFBBFDFBBB@DB@@DCBCFAHAB@B@HCB@DADBDBJFD@D@B@D@PCD@F@FBRDJ@F@BADA@ABABEBE@A@ADAD@DBBBFBBBBDBBFDHAB@@@P@D@DAFEBA@AAA@@CCAACA@AACAC@A@ADAFA@AB@D@D@D@BABA@ACEAEBCBCDCBGBCCGAABAAC@C@@EE@CBE@@BCBCCAFGHCD@DAFBB@DAFCBAFEBEDAFCBABC@EBCBCDADAD@DA@A@C@CBAHCBA@CAC@C@CHEFAXGFEBA@A@C@EBCD@B@DBJAB@@@BABA@AGCCAECCCCA@AACBCD@D@D@BFBBB@DCDADADBB@DABA@CAA@ADAHADCBC@ADABABCBABAA@@A@@AC@A@ABA@@DAF@DABABA@A@@AAEE@A@ABAD@D@BBDBD@@@@@B@BA@A@A@CBA@ABA@@HG@A@AA@AACBE@AAAABA@CFMBE@CAE@AAAAA@AAA@EACA@AAABC@ADABABC@A@@ABA@AAA@C@AAA@A@ABCAA@@@@A@@@G@C@EA@@@BM@E@A@A@CB@@A@CAA@@@A@A@AAA@EACA@@@AA@@AA@AAA@AA@@A@AAA@A@A@C@@@A@A@A@@@@@AA@@@@@C@A@@@@A@@@@@A@CA@@AA@@A@AACAA@@AAA@AA@AA@@@AA@@@@A@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@A@@@@A@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@A@@@@@A@@@@A@@A@@@@@A@@A@@@@A@@@@@@AA@@@@@A@@@@@@@A@@A@@@@@@@@@CC@@@@AA@@@@@A@@@@@@@A@@B@@A@@BA@@@@@A@@@A@@@AB@@@@A@@@A@A@@@@@A@@@@@A@@@A@@@A@A@@@A@@@A@A@@BA@@@@@@@@AA@AA@A@AAA@@@AA@@AAA@@A@@@AA@@C@A@@AA@A@@@A@A@A@@@A@A@@@A@@@@@A@@@@@AA@@@AAAAA@A@AC@@AA@CAA@A@@AA@@AA@@BA@@@AB@@A@A@A@A@@BA@@@A@E@A@A@A@A@A@AB@@C@ABA@@@ABA@A@@@A@A@A@@@@@ABA@@@A@@@@@A@@@@BA@@@A@@B@AAB@@@@CBA@A@@@A@@BC@A@@@A@@@AAA@AB@@@@AB@@A@@@A@@BA@@@AB@@A@@AA@C@C@A@ABC@@@AB@BAB@@@B@@@BABA@@@@@@@AB@@@@A@ABA@@@A@@B@@AB@@@@@BA@@BABA@@@AB@@ABABCDCDABA@@BA@@@@BAA@@A@@@@@A@@@AB@@@B@@@@A@@B@@A@@DCDCDCBA@ABA@@@A@@@AD@@AB@BADABABA@@BC@@BA@@@ABA@A@@@A@@@@BC@@@@ACAACKA@@A@@@@@A@@@A@@@AAA@A@A@ABA@C@AA@BCAA@CAA@A@C@CACEE@C@@@@@A@ABAB@@AB@B@@A@@@@@@@@@@@A@@@@AA@A@A@@@ABA@@B@B@@@B@@@@AAA@A@@@A@@B@DA@AB@DC@AB@@@@ABA@@@A@A@@@@@A@@@A@@@@@A@AAA@A@A@@@AAA@@AA@@AA@@@A@A@@BA@@@@@AAABA@A@@@A@A@@@ABA@@@A@@@@BA@@@@@CA@@A@@A@@A@C@A@C@E@C@@B@@A@@@@AA@@A@@@@@AA@@A@@@A@AAEA@A@@@@AA@@@@@AB@@A@A@@@@@A@@@AA@C@C@A@@A@CBCB@@A@@B@DBB@@A@@@@@@@@@@@A@@@A@@@@JE@@B@@@B@B@@@@@@A@A@A@@@@BA@@BA@@@@@A@C@@@A@@@A@ABA@ABA@@@C@ABCAA@@B@BCBABA@A@@B@@E@@SGICMA@@@@YEGACACGMYCGAACCAAG@IBOB[@K@G@CCEEC@E@C@CDGDMDMDG@GACACGCCAAE@EBA@@ABC@CAGEAQAM@@ACAA@A@C@ABABCDABABCDEBC@CB@BABABAF@D@B@@@F@BA@A@ABA@@BC@C@A@A@A@AAA@E@@@C@EAABC@C@A@G@CACAA@EA@@CA@@A@C@@@C@@@CA@@C@@@A@@@@BAAECCAEAA@AA@@@@A@C@@@@AB@@A@@A@BAA@@@A@@@A@A@@FECA@AB@@AB@@@@A@@@@@AA@@@@A@@@@@@@A@@@@@C@A@A@A@ABE@A@AAC@@@@@@@CBA@AA@@AA@A@@A@@@CB@BA@@CCB@CAB@E@AA@A@A@A@@@A@G@@BC@ABA@C@ABA@@@@A@@AA@BA@A@@@@@CB@@CCCA@AA@@A@BA@@@@@@BA@A@@@@@@@@@A@@@@@@@A@A@@@@@@@@B@@AB@@@BBBDDDBABBBB@@@@BC@BB@@BD@@CDABMBC@@@A@A@AB@AA@A@ABA@@@A@A@@@@@@BA@A@A@@@@AA@BAA@A@AA@AB@BBBBB@BA@@BAB@@@@@@@AA@@A@@A@@AA@@ABABA@A@@@CDA@ABABA@@A@@@@AB@@A@BB@BA@ADAAA@@A@A@A@@@@E@@@@B@D@@AA@C@@@A@B@D@BA@A@A@C@@@@@AB@@AA@@@@A@@@A@@B@DBD@@A@@@A@C@@A@@@AAA@@A@@BBB@@@@A@@@E@CAA@@@@@DFC@A@AA@CA@@@@BA@@@A@C@A@C@AB@@ABA@A@AA@@AA@@AB@@@BA@A@A@A@A@EAA@A@ABA@@DA@BDABAB@B@B@@@B@BHB@B@@ABC@G@A@@@@FA@CAABCACB@D@B@BB@@BAB@@B@BBB@@@@@@@BB@@B@@B@@C@AB@BA@@@@@AA@@@A@B@@A@@B@@@@@@AB@@@@@B@@@@@@@@AB@@@@@B@@A@@AA@A@A@@@A@ABA@E@SAB@@A@AB@@CBA@@BE@AB@@@B@FCB@BAB@DEB@AA@AA@@@@@A@A@CBCB@@@B@BA@C@A@@A@@C@@B@@EB@@BDABABA@A@@@A@A@@@@@@A@@A@@@A@A@@@@@@B@@A@@@AA@BAB@@@BA@@@@BA@A@C@@@BAA@A@A@AB@@CBC@AAA@AB@@@@@A@C@@@@A@A@CAA@@@C@@@C@AA@@A@A@A@A@@@A@A@A@@@BB@@A@A@CBC@@ACACCAAB@B@FABA@C@C@AA@C@A@@A@AA@A@C@C@@@A@@BBBAB@@@AA@A@AA@@@ABA@A@AAA@@@A@@@AB@@@AA@A@A@@@@C@@AA@@BABABABCAA@@@@@CBGB@A@A@AC@AAAAFAA@EAA@@A@A@@@@A@@@@BAB@@AB@@A@AAA@@@@AA@A@CACAAAA@A@EHAB@@@@@@A@A@EBA@E@EB@@EA@@A@@@CBEB@@C@KBA@A@A@@@C@A@A@@@A@A@EAA@A@@@A@@@AB@@A@@B@@A@AB@@A@@@@@A@@@A@@@A@@@@@A@@BA@@B@BBF@B@@@@A@A@A@EEEGCCAAC@AC@AAA@@AA@CBA@CBADAA@@@A@@@AA@@A@@@AAA@A@@@G@@@@@@B@@A@A@@@C@A@A@ABA@CAAA@@AAECCAC@AH@R@HAJCBABEDKDIJCBABIDGHEBABEDEFEDEBE@A@K@G@E@C@CDCBCDBBBDDDDDHDFBDDBD@DABA@ABGBGBGBEDCFADADCFCJCNADALALAH@DCD@BABABA@ADEFEBEBIBA@KDEF@HAD@BCJGBO@IDCFAD@BEHADBBDBD@D@D@DBDB@D@@@DADA@@BCBE@A@A@CAA@A@GAC@@@ECA@GCGAA@G@E@E@G@CBCBCD@BCFADCDCBE@EBGBC@C@A@G@KBA@E@KFODQJEDEBKBABABABABCFAD@BDD@@BB@B@HBFDFDDDB@BDF@D@BEF@@KFGDKD@@A@AAE@CAEAI@G@GAIBGBEDMBG@AAECA@A@AAC@EAK@CBABCB@BADCBEJKJIJG@SBA@E@"],["@@BCBADCD@@@FCB@LAD@B@@@BA@@@@@AA@@CA@@@AAA@A@A@@@CBCDC@A@C@A@A@CAC@AA@@@@@@A@@AECA@A@A@CBA@@B@@A@@B@B@@B@@B@B@@@B@B@@@B@BB@@@@A@@@A@@D@@@@@B@@BBBBB@@BB@BB@BB@@BBA@@@CBC@AB@@AAAAA@DCDC@A@@@@A@@@@@A@@@@@A@@@A@A@@@@@@B@@@@@@@@@@@BA@@@@@@B@@A@@@@@A@@@@@A@@@@@AB@@@@B@@@BAB@B@@@@BAB@B@@AD@B@B@@@BAB@@ABA@A@@@A@@@A@@B@@A@@@A@@B@@F@FAD@@@B@BA@@B@@@@A@@AA@@@AB@@@BA@A@@B@@@@AD@@@DA@@@@@@@@@@@@@BE@AB@@@@@@@@@@B@@@@@@@@@@@@@A@@BA@@@@@@@@@@@@@@@@@@@B@@@@@@@A@@B@@@B@BA@@B@@@@B@B@D@DABABA@ADCBA@@BA"],["@@@@A@A@@@ABB@D@ADABDBBA@C@@@@@A@@AA"],["@@@@ABA@@B@@A@@B@@@@@@DABA@@B@@AA@"],["@@@B@@@A@@B@@@@A@@@@@@@AA@@@@@@@@B@@@@@@@@@@@B@@@@@@"],["@@@A@AAA@@@A@@@D@@@B@B@B@@B@@@@A"],["@@@@@A@@B@@@AA@B@@@B@B@@@B@@@A@@@A"],["@@B@@@@@AC@B@@A@@@@AEBBB@@AAABB@BBFA"],["@@@@BAA@@@CBABAB@BB@FE"],["@@AA@@BBFAACACAB@DEBA@@BB@B@BBBA"]],"encodeOffsets":[[[129075,45862]],[[129264,45773]],[[129239,45777]],[[129235,45779]],[[129241,45775]],[[129244,45772]],[[129242,45770]],[[129762,45603]],[[129749,45600]],[[129758,45602]]]}}],"UTF8Encoding":true});}));