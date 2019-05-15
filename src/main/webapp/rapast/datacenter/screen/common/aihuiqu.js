(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('爱辉区', {"type":"FeatureCollection","features":[{"type":"Feature","id":"231102","properties":{"name":"爱辉区","cp":[127.497639,50.249027],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@ABA@@BA@@@@@@BA@@B@@AB@@A@A@@@@@AB@@A@A@A@A@@@A@A@@@C@@@A@A@@@@BAB@BABABABABC@AB@@@@ABA@A@A@@@AB@@A@@@ABC@EBGBE@A@C@ABC@E@A@@BABABAB@@A@A@C@A@C@C@A@CBC@EBC@C@CBC@ABCBCBABABA@CDABADABAB@DA@ABEBABA@ABABADA@ABEBEBC@CBC@CBABCDCDA@@BB@DBBBBDBB@BAB@D@@BBBBBB@B@@@BA@C@A@C@ABABABABBB@B@BB@AB@B@@@B@@BBBBBBBB@B@BABA@ABCBCBABABAB@BA@@BABCD@@AB@BABABCBCBABCBA@@B@@DBB@DDBBDBDB@BDADBD@BBHBHBD@DBBDB@@@@B@@@@@@ABA@@B@@@@@B@@@@@@@@@BA@@@@B@B@@@@@B@B@H@@A@@BA@CBIF@@@@@B@@@@@@BF@@@BDF@@A@@@@@@B@@@@B@@@BB@@FB@@HF@@@B@B@D@B@@BBFFB@@@ADAJ@@@B@@@@GDA@A@@@@BGD@BAB@@@@GB@BABCBGH@@@@@BEBAB@@CJ@@@@@@@@@@@@@@EHED@@@BAD@@@@@@BDBB@@LH@@@B@J@@@@@@@@ADB@@@@@@@@B@@@@@B@@DBBB@@B@B@B@@@@@@@@@@@FA@@B@BBB@BD@BAD@DA@@@@@AB@@OH@@EF@BAB@@GB@@CBAB@@@@@BIFA@EBE@KB@B@@@@C@@@A@EF@@A@@@I@A@@BCBCBCH@B@@@F@@AD@@@@@@@@@@@@@B@@@@@@BB@@DDB@DN@@@B@B@L@@AH@B@@@@@@@@BB@@@@D@H@B@D@JBB@@@BB@@@@@BBBA@AJ@@@@@BB@@@@@@BB@BN@@@@B@@BBB@B@D@BA@@BABCBCBABABA@CBE@A@CAA@A@E@C@@@@AA@A@@@A@A@A@ABAAA@@@E@A@C@@@A@AA@@C@ABA@A@A@A@ABA@E@AB@@GD@@A@A@@BA@A@@@CBAB@@AB@@AB@@@@CBA@@@ABA@IDC@A@E@A@A@A@@@ABEBABA@CBABAB@@A@@BC@A@A@A@@BA@C@@AEBCAEBA@@@C@CA@@AACA@@A@C@A@A@A@@@AAA@A@A@A@@A@A@@@A@AA@A@C@CAA@A@A@@AA@@AEAAA@@A@C@A@A@A@A@A@CBA@A@K@@@AAA@@@@A@@AA@@@@EAA@A@@A@@@AA@AAA@@@AAEBAAA@@@A@@AE@C@AAAA@@@@AAAAA@@@A@@@AAA@A@@@@AA@@@AAA@ABA@@@C@G@A@@@A@A@A@@@G@@@@AA@@A@@AB@@A@CAA@AAA@AA@A@A@@@A@@A@@@A@A@@BA@@B@@ABABAB@@ABA@@B@@AB@@A@AAA@AAA@A@AAA@AAC@AA@AC@A@A@A@C@C@A@A@AB@@C@I@AA@BA@ABE@ABABA@AB@@@@AAA@@@A@A@@AAA@@@AAA@@@A@A@@BABA@@ACA@@A@@AA@AAAAA@@@A@CAAA@@@A@AAA@@@@A@@B@@@@AA@AAA@AA@@A@@@A@A@@@@ABA@@AA@AA@A@@@@A@@@@A@@@@@BADAD@DAD@@AB@@@B@B@B@BAD@@@B@DCBA@@@A@@AAA@A@@@@@@A@@A@@A@@@ABA@@BA@@@@AAA@@@A@AAA@A@@AAAA@A@A@C@@@ABA@A@A@A@A@A@A@AAC@AAA@A@ABAB@BA@ABA@A@@@@AA@A@@BA@A@A@AB@@@@@BCBA@A@@@A@AA@@@@@AA@@AA@@A@@AA@@A@A@@AABAA@@B@@AA@A@@B@B@@@@A@A@AAAA@@A@@AA@@@AC@@@A@A@@BA@@BA@@@A@@BAB@BA@AAA@@@@BA@@A@@AAAAA@@A@@BA@@@A@A@@A@@BA@AA@AB@@AAA@E@@AA@A@A@@@@BB@@B@BA@A@A@@@EBA@C@@@A@A@@BAB@B@B@B@B@H@@@BE@CBC@C@A@@@A@A@@ABA@@@@A@A@AAC@A@C@A@C@A@A@A@A@@@ABA@ABAB@@@BA@AB@B@B@@@BA@@@ABA@C@A@A@AACCAAA@A@@@GFABCBA@AAA@AAAA@A@AA@A@C@A@A@@@A@ABA@@@CBA@@@AA@@@C@ABA@AA@A@C@A@CBA@@B@BB@@@@BCBADABCBA@@BA@@@ABA@AB@@AB@BBBA@ABA@AB@@@BC@@BAB@B@BCDABBBB@@BABB@@BBB@D@DAB@B@B@DBBB@@BBB@@@BBB@@BDBBBBB@@B@BABAB@B@@@BB@B@AB@B@@@B@@@B@@AB@@@B@@A@AB@@@DAB@B@BBB@B@BBD@D@B@BBBB@DBBDDFBFHHHDJHB@@BBB@B@B@@@BBD@D@DADADBBAB@BBB@BADABC@ABAB@B@BADGF@BABABBBFF@B@FBBBBBD@DABCDEF@BCHIFCDCFADGFGBCDADCDCBGHIFEDCL@DCFAH@F@HAJADEFBF@DAFABADABEJAD@FBBBD@BFF@B@BABAH@DADBBBBBBA@AB@BA@ADA@@BA@@@C@A@A@C@C@A@A@A@@@AB@@EBA@EBABA@@BAB@@@@CDA@@@@BA@A@ABC@ABA@ABAB@@AB@@@@A@@B@@A@@B@@@@@B@@AB@@@B@@AB@@@B@@@B@@@BB@@@@B@@@B@B@@@@@B@@@@@@@B@@B@@B@B@@B@@B@@@BB@@B@@BB@BA@@B@B@@A@@B@@@@@B@@@@@B@@@@@@AB@@@@@@B@@BA@@B@@@@@B@@@@A@@B@@@@A@@B@@A@@@@@@@@B@@A@@@@B@@@@@@AB@@A@@@@@@B@@A@@BA@@@@@A@@@ABA@@@@@@@A@@@@B@@@@@@@@@BA@@@@@@@@B@@A@@@@@@@@BA@@@EDABAB@B@@@BA@@B@@A@@B@@ABA@@BEDABC@ABA@A@@BAAA@A@C@A@@BCB@@A@E@A@@BA@A@E@A@A@C@A@@BA@A@@@A@ABA@AB@@ABA@@@@BA@A@A@C@A@A@A@ACA@C@A@@@A@@BCB@@EB@BA@A@A@@BC@AB@@A@@@E@ABA@CBAB@@A@A@@@ABA@C@@@ABA@@BA@@B@BA@@B@@ABA@@@A@@@BB@@BBB@@@DB@@@@@BAB@@A@A@A@ABA@@@A@ABA@@B@@ABBBB@@BH@DABBF@@AB@B@@@B@FA@BB@B@@@B@@BD@@@B@@@B@@D@@@BB@@@BABB@@@BB@B@@@B@BBB@B@@@F@@@B@@@B@@@@BB@ABAB@@A@A@ABA@@@ABA@A@@@E@AB@@A@A@GFAB@@AB@@@B@@@BDBBB@@@BBB@B@BB@@BB@BB@@B@@BB@B@D@B@BAB@B@@A@@B@BA@@HEBAB@@@B@BAB@F@B@@@BBD@@BB@@B@@@BB@@B@BB@@@BB@@@BB@@BB@@BB@@@@B@D@@@B@@A@@B@B@@B@B@D@B@@B@@@BA@BB@@B@B@@@BBB@@B@@AB@@@B@D@B@@A@@BEDA@@BA@A@C@A@ABC@A@C@C@ABC@A@A@AAA@@@C@@@A@ABA@ABA@A@ABA@ABA@@B@@C@A@A@A@@@C@C@A@A@@B@@A@@@@BA@@BABA@AB@@A@@BA@@@@@@B@@@@@D@@@@@BC@A@A@@@AB@@@@AB@@@@@B@@@@@BBB@B@@@B@@AB@@AB@B@@@@BBB@B@@B@@@@@B@@@@@BAB@B@B@B@B@@@B@@B@@BBBB@BBB@BBBD@@@B@B@@@B@@@@BB@B@B@BG@M@G@O@I@I@E@K@C@@@@B@@@@@B@@@@A@@@BBA@@@@BA@@B@@A@@B@@AB@@@FCB@B@D@@@@@@AB@@@B@@A@@B@@AB@B@F@B@@@@@BBHAB@@@B@D@B@@BB@D@BBDA@@B@@AB@@BB@B@BBBAB@B@D@B@@AB@@CD@@@F@B@@@BBD@DBBBD@BBB@DBD@BBB@BBDBBBDBDBFBDBFDDBFBDBDBDBD@B@D@DBB@B@@BBBB@@BBBBBBB@DBDBB@@BB@@BB@@BBBBBBBB@@@B@BBBBBBDDBBBBBDBB@@@B@DBB@@BD@@BBBBDBBBDBDDBBDDBBBB@BBB@@@D@D@B@D@B@D@B@D@BAD@B@D@BAB@B@BA@@BA@@BB@@BBB@@@B@B@B@B@B@B@D@B@D@B@BBB@B@BB@@B@D@@@BBBBB@@@BA@ABADA@@DB@BD@@@BBB@B@BBB@@BBBBB@@B@@DDDDDDBBBBB@BBDBB@B@D@DBB@BBD@@BB@DBBBDDB@DBBBBBBBD@DBDBB@BB@BBBB@@@BBB@B@B@B@F@B@B@B@B@DBB@@@DB@@DB@BB@BBBBDB@BBBBD@BBB@@BDBDFDDDDBBBBDB@BBB@BBDBBBDBBBB@BBD@BBD@D@H@B@DBDAB@@@@@B@@@DB@@D@DBD@BBD@D@BBB@BBD@@@DBBBBB@BBB@B@@@@B@BADAHAFAD@DAF@D@DBD@FBDBFB@@DBD@BBBBB@BDBBBBBDBB@@@BB@B@B@DBFBB@B@DBBBB@BBB@BBA@@B@@@B@BAB@B@B@@@B@B@@BBBBBBB@@BB@BBB@B@B@B@BBD@@BD@@BBB@@BB@@B@B@@@D@B@B@B@B@BBB@BBDDBB@@BD@B@BB@@BBB@BDBBB@BD@BB@@D@@@@@BB@BBBBB@B@BBBB@BBDBDBD@B@B@@BB@B@BB@B@B@B@DABA@AB@@BD@B@B@BBBBB@B@B@@@B@B@B@@B@DBBB@BBB@B@B@DAB@@BBBBBD@B@DBD@B@BBD@BBDBB@DBDBBBD@BB@@DBB@DBD@B@D@D@BAD@@@@@@@FAH@HAN@LAL@F@FAF@F@D@FAD@F@F@FAF@F@DAF@F@D@DAD@D@D@D@B@B@BBDBB@BB@@D@@BBD@BBDB@BB@@BBBBB@@B@@B@@@B@@BB@BDBDBFD@@BBBB@@@@ABC@CBC@C@C@A@ABA@AB@@@BBBAB@BAB@@@BB@BB@DBB@B@BBB@@@BBBB@FDBBD@@BBB@@BBBBB@B@D@D@B@B@D@D@DDDBDBDBD@D@DBB@D@@B@BB@@B@BABADAD@@A@ABA@@@@B@@BB@@@B@BA@ABA@A@@@AB@@@@@@@@@@@@BBD@D@BBB@B@@BBBB@@BBB@BBBB@BBBBB@@B@BAB@BAB@@AB@@@BBB@@@B@BAB@@@B@BB@BBDBBBDBDDDBFBB@BB@@@BABAB@DAD@@@B@F@DABAB@BB@@B@BDBDBB@BB@@@B@D@@@D@BAB@@ABABAB@@B@@@BBDB@BBBA@@BBB@B@@@B@@A@ABAB@BABABA@@B@@AB@BB@BB@@@BBB@DBB@B@BB@DBBB@@@BBB@B@BBBBBBBB@BBABBD@B@B@B@BAB@B@@@B@@BB@D@BABA@@B@BBBBBBB@BBDAB@BBBD@D@B@@@@AAABA@AB@D@BABBB@BB@@B@@@@AB@B@BA@@DAD@@@@B@BBBBBBB@@BB@@@BB@B@B@BB@@B@@@BB@@@@BB@@B@B@@B@@@@@@@@@@@@@@@B@@A@@B@@B@@BB@@@@@@BB@DB@DB@@BAB@BB@@@B@D@F@F@D@BB@@@@@BAD@@BD@D@BBBBBDBDBD@DBD@FBFBDBD@FDDDBBBBBD@DB@DBHDDBF@DB@@BBB@BBBBBFBDDDDDBBBBBDBDBBBBBB@B@B@BAD@DAB@BCDCDABABAB@B@B@BBBDDDFDD@B@B@BABABCDABCBCD@BAD@@BDBB@BABBFBD@B@B@B@B@B@@@BB@@BAB@D@BBB@BB@DDBB@B@BBBDBBB@BBBA@@B@BCBABCBCLENFCHCJCHCJEJCJEHCDADAFEHCFEHEHCFEHCFEHEHCBCFAHEHCBAR@DBD@D@DBB@B@B@B@B@B@DAB@DCB@BAB@BAB@@@@@@A@A@@@C@AA@@A@@B@@A@@@@@@BAB@@AFCBAB@@AB@@@@AB@@@@AB@@@@A@@B@@AB@@AB@@AB@@AB@@AB@@AB@BAB@BAD@BAB@HBH@J@J@JBF@J@D@@@B@D@F@D@B@D@B@F@D@H@J@H@J@H@H@J@FBJ@H@D@J@JBH@JBF@H@JBH@H@FBJAHAJAHAHAJ@FAFBLD@@HDHBHDHBHDFBFCFCFAFCFCFCDBF@B@B@F@HBF@D@D@F@DBHBJBF@JBHBHBHBD@F@J@H@B@@@DBB@B@B@P@FA@@B@@BB@@@B@@@@@B@@@@@B@@@D@HBFBL@L@J@J@J@J@J@L@L@J@J@L@J@J@J@H@D@JBLBJBLBJ@JBJBLBJBJ@L@J@JBL@J@J@J@B@HBFBB@BBFBFBBB@@B@@B@@BB@@D@B@B@DAB@B@BA@@B@@AB@@ABA@@B@B@DAB@B@@@B@DBFDDBB@B@D@@BB@@B@@AB@BABABA@@B@B@BA@@B@B@@@D@BBD@BA@@BAB@@B@@B@@@B@@BBD@BB@@BB@B@@BBBBBB@@@BDBBBBB@B@BAB@@A@@@@B@@@@@B@D@@DDB@@B@@@@@BBB@B@B@@B@@B@@B@BB@BF@TFLKJGVOhOxU^MVShcTYPUXgV]­PSJOLKHEjSVEfIPMDQ@KAKKIKMESAMBO@YJ_JKHGZ]TQVITa^[HELUAKAIAIEQCKCGCCIGaMQGKIM]K]O]KKCIAKFIRKRGRCZA^ARGLIDK@K@[FQCIGKMKU[KMAEEMEOAG@IJQHGNOTS\\[nWTENAjK^GTA^ETEPCMQhGVALCFEFM@WAcAO@[OgEOQ[omkaI_AJUbaf[PSHO@McÃAS@UFeFGHKLMLIJIRKfMEGLAPEJGDGBG@FMBIB@@C@A@A@AAA@A@A@@@C@A@@BA@C@A@A@CBABA@@@A@@@@@@AAA@A@@@A@A@@@AA@@@AA@@@@@@A@AB@@A@A@@AA@@@A@@@@@@@AA@@A@@@@@@@A@@A@@A@@@A@A@A@AB@@@@A@@@@A@@AA@@AA@@A@@A@A@@@@AA@@AAA@AA@@@@AA@A@@AA@@AAAA@@AAA@@@@@@A@@BA@@@@@CB@@A@@@A@@@@@AB@BABAB@B@@@@A@@@A@@@@@A@@A@@A@A@A@A@@AA@@AAA@AAA@@@A@A@@@A@A@@@A@A@@A@@A@@A@@A@@@A@@@AA@@@@A@@@@@A@AA@@@@@A@@@A@A@@@@@A@@A@@@@@A@@@EBC@AB@@AB@@@@A@@@@@@@@A@@@@@@AA@@A@AAGAC@AA@@A@@@A@@@A@@@@@A@ABA@@@A@@@@@AA@@AA@A@A@C@A@@@@AAAAAAAC@A@A@C@@@@CC@@@ABC@A@AA@@@@@A@AB@@@@A@@@@@AAA@CEQM@A@@A@CBA@@B@@@@BDBBA@@B@@AAA@EACAAA@@CACACAC@A@@@AA@@@@A@@@@@A@@@@@A@@B@@@@A@@@A@@@@@A@@B@@A@@@A@A@@@A@@@A@@@A@A@@@A@A@A@@@@@A@A@@@A@@@@@AA@@A@@@@@A@@A@@A@@@@@A@@@A@@@@@@@A@@@@@A@A@@@A@A@A@AAA@@@A@A@@@A@@@@@A@A@A@C@@@A@@@AA@@A@@@A@@@A@A@A@A@@AA@A@A@@@A@@@A@A@@@A@A@@A@@A@@@A@@@@@@@A@@@@@A@ABA@A@@@ABA@A@A@A@AB@@A@A@A@A@A@A@C@@@C@A@A@@@A@A@ABA@@@C@A@A@A@@@C@A@@@A@A@@AA@@@A@AA@BABCBA@CDA@@@C@@@E@EAG@C@@@A@@@CBEDGB@@ABCBABGDAB@@CD@@@@@B@BA@ABA@CBA@E@@@AB@@A@@BAB@@GD@BA@GDA@AB@@KDE@EBA@@BABABA@A@MD@@A@@@ECAAAAA@AA@@CA@@AAAC@@@BAB@@A@@BA@CBA@ADA@A@C@EDCBA@@@C@EAC@CAE@@@@@@BA@@BA@CF@@EDABABA@@B@@@B@BB@GFCBA@AB@@C@C@C@A@A@AA@@A@A@A@AA@@A@@@A@AAIE@@AA@@@AA@@@@A@E@ABA@@@@@AB@@A@AAA@A@A@@@C@A@@BAAC@@AAA@AAAAAAC@@AA@@@A@@A@@A@AAA@A@A@A@ABAA@@CA@@AA@@AAAA@A@A@@AAABA@A@@@A@AA@@@A@@@A@AA@@@CA@AA@A@@@AAA@AAA@@@@A@@AA@@@@AA@@@AA@AA@@A@AA@@AA@@A@CC@@C@A@A@A@A@@@C@G@C@C@A@A@ABI@A@AAA@@@AAA@@@A@AA@@A@AAA@A@A@G@AAQ@C@C@A@CBA@A@A@ABA@ABA@@BEB@@ABA@@@A@A@CBEACBC@C@CAA@ABA@A@CBABCD@BABABABABABA@@@A@@B@@A@A@AB@@A@C@A@AA@@AC@@@AAA@AAA@@A@@AA@@@A@@@A@@AA@@@A@@@A@@@A@@@A@@@@@A@@@@AA@@@A@@@A@AA@@@@A@@@@@@AA@@@@@A@@A@@A@@@A@@@@A@@A@A@@A@@A@@@@@AA@@@@A@@@@@A@@@@A@@@@@@@@A@@@@@@@@@@@@@A@@@@@@@@@@@@@@@@@@A@@@@@@@@@@B@@AB@B@BBB@B@BA@@@AB@@CA@@@AAKEAACAA@A@AAA@EBE@E@C@A@E@C@A@AA@@A@A@A@C@A@A@A@A@CAA@A@C@A@AAA@A@AAA@CAC@C@E@A@A@CAC@E@C@AAAAA@@AAAA@AAA@@@AAAA@@@AAE@A@AA@@A@A@@AC@A@@A@AA@@@AB@@@BAB@@AA@A@AA@@AA@@A@AAA@@BC@A@A@A@A@@@A@ABA@A@@BB@@BD@B@DB@@B@@@@BA@A@@@A@A@@@A@@B@@@@@@C@AB@@@@@BA@@@A@AAA@@@@A@@AA@@A@A@A@@BABA@A@@@A@A@AAA@@@A@C@@@AAC@A@A@A@A@A@ABA@ABA@ABA@A@A@C@AACACAEAAAAAA@@@OGA@CAA@A@@@AAA@@@A@E@A@A@@@@BABBB@@BBBBB@@B@@B@@D@@CBAB@@A@A@E@@@CAAAECAACA@@A@AAA@AAA@A@@AA@A@@@A@@@AAA@@@A@@@AAA@CA@@@AAAB@@AB@BA@A@AA@AAA@@AA@C@I@C@AAA@A@A@A@@AA@A@A@A@AAA@C@I@A@G@G@E@A@AAA@CA@@AAA@AA@@@AAAAA@@@@BA@@BA@@BA@A@AB@@@BABA@@@C@A@A@@CMGKOOEE@@EAA@MG@@@AA@BA@@@ADAB@FCB@BAB@@@B@B@D@B@B@D@A@AAC@CAA@C@CAEACAA@CAAAA@AA@@@C@A@A@CBA@C@A@A@CAC@CAAAE@AACAAAAAAAACAC@E@IAG@EAE@CAEAEAECECIGEACA@@AA@AAAAAA@CA@AAA@C@A@CAAAACAEAEA@@@@@AA@CACACCA@AACC@AAACAAACCAACAAAA@CACBA@A@A@C@CBC@CBE@A@A@ABA@C@C@ABA@A@CBE@CBC@CBC@ABA@AB@@ABA@@BABA@@@CBA@ABA@C@@BC@@B@@AB@@@B@@ABA@C@E@A@A@A@ABA@@@A@"],"encodeOffsets":[[129707,50623]]}}],"UTF8Encoding":true});}));