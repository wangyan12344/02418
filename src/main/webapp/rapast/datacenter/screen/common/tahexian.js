(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('塔河县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"232722","properties":{"name":"塔河县","cp":[124.710516,52.335229],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@`OTC`MDCJQX[BG@EACBEBEJENKFCDCDCBCBKBGDGHGSJA^UDCDG@GDCFCPCJAJAH@HAH@DAH@D@D@H@J@FAJGJKpGCTFNDJBLBR@J@JBL@J@F@AtCJ@HAJCdOVGLICQY_NO`ONCzGR@RAJLCJEHMJQDMDKHGHELGFCJAfFPJHLDLGNGJELEHAHCDADAHEJAF@B@F@D°hzT`FJH@HBV@P@xD¶@\\CFAJ@ZCJA\\@fI[^Mp_FCnUZB^AZKbKnCHAFCFCDCFCBAFAJ@HAFCJCJGVCNCTARClGVKDMEOAQ@GBEDGPMJEHCLBHBHDLFJFHDJFNHxZNDPBV@LCJE^[BEDW@IBGBCDCHEDEJCPGLK\\WQNAJCHAFAFADADCFEDCAAGGACAAGCGECAAACC@A@EBCBIDGBIBC@EAAEECCECGCAAEA_EeCSGICMQCGAKAIBIBADOBIAIBKHG@CFAJCHBJBHBF@FBDBDBBBFBDBBBDDBDDDBBHBFBDBP@ZBL@F@FBBBFFBDNJLJB@JBD@DARCDAR@D@MGEAAAKGGECAICKCECKEAAGAGAME@GAACAAAC@AA@AA@@A@@BA@E@AAAG@GACAECCC@C@A@C@CBABAHG@@AAEGCCACEC@ACCCAGCGACACABA@ABCAACACAE@EAEAECCACAAAACAACACACACACAAA@C@ABE@CBC@CAA@CBC@ADCDC@C@AA@E@E@GBGBE@C@CACEC@EAEAE@EAEAAAAABC@A@ABCJKBEBCBC@AAAAACAEAC@CAGCA@ACCC@@@AACAACACAEAE@CACAEACAEAACCCCACCEACCECEACAACCCAEAA@A@ABAFAFAFAFAD@FAJAB@DADABA@A@AAEAEAC@C@C@@DE@@FAFADADCDABCBCDAB@DADCBABCBABA@A@CBABAFC@@@AKA@AEAC@CACACAC@CAC@A@GBABCBC@G@E@E@E@C@CACACAC@GAECAAAAAABABCDADAFADADADA@ABA@C@C@ABC@ABCBADABCBEBCBC@A@A@@AA@@AC@A@AA@@ABC@ACE@AB@@@DC@@@ACI@A@@AA@@A@CC@@@C@@@AB@DA@AAA@@@@AA@@@AA@@@@AAA@@@A@@AA@@@AC@@AA@@@@@@E@A@@@A@AA@@A@@@AB@B@B@BA@@AC@@@A@@A@CC@@B@F@B@B@B@H@B@@@B@@@B@@@BA@@B@@@B@@@BA@@B@BADALEBAB@@AB@B@B@B@D@B@@@B@@@D@DABABABA@CBC@A@E@CBG@UBMPSHCDCBAFAHAH@HBB@B@B@B@B@@AB@B@@@@@B@B@BAB@@@B@BA@@B@BA@@B@@@B@@@B@@AB@DA@@B@@AB@@@FBB@B@J@D@DA@@B@B@@@@@BA@@B@B@H@P@F@B@B@BA@@B@@@B@@@B@@AB@B@B@@@B@@AB@@@B@B@@A@@B@B@BADA@@B@@AB@@A@@BAB@@@@A@@CA@AA@@A@@@@@C@A@@@@BA@@B@D@@@@A@@A@@CB@@@B@B@D@@@BA@@@@@@@ABAA@@A@@@@@C@@@AB@@@BA@@@@@AAABAB@@@@A@@AAA@@@@AB@B@@@B@@BB@B@@A@@B@@A@@@@BAAA@@@@@A@@B@D@B@BA@@@A@A@CB@@A@AA@BC@@B@BA@AAAA@AC@A@A@@DAB@JAB@BBB@B@B@BABAD@@BDAB@B@B@@@BB@@B@BAB@B@B@DB@@B@@@BA@@@@B@B@@@D@B@@@B@@@@A@A@@@AB@D@DADAFC@@@AB@BAB@BA@@@AB@BBB@D@DADABA@ABA@ADADABAB@B@B@@@@A@AB@B@B@B@BA@@@A@A@A@@@A@AB@BABCBC@A@@CGECUOcWKCCAG@C@KFEDE@C@GAeKeKSC[EK@E@@@CFADA@C@C@E@CAGAG@E@EBGBCBGHADC@A@A@AAECCCG@CAEBE@aFG@CAE@KEICC@C@C@A@QJCDEBCBCBA@AAOICACAE@C@G@UFIBA@C@QEWGMCGBABA@A@EAA@@A@AA@@@AA@@A@@@AAABA@@BA@@@C@C@@@A@@A@@AC@A@@A@@@@@@@A@@@@@@@@BAB@@@@A@A@@@AAC@@@A@@BA@@@A@@@@@A@@AA@@AA@AB@@@@@@AB@@AB@@A@@@A@@@A@@BA@A@@@A@A@A@@BA@A@A@A@@A@@BA@A@@A@A@@@A@@BA@@@A@@@A@@BA@A@@@AA@@@@CB@@A@A@A@@A@@A@@AA@A@A@@@ABA@A@A@@@A@@AA@@@A@@@@AA@BAAAA@A@@@ECAAECAAA@A@ABG@A@@@@@A@@C@@A@AA@BGB@BBB@@B@AB@@C@GAAACC@A@A@A@@@AB@@@@@BAA@AA@@A@@@A@AA@AB@B@@@BA@@@AA@@AC@@A@ABAA@AAA@@@C@C@A@@@AA@@A@BA@@B@BA@@B@@@@A@@@@AAE@C@@@A@@@A@@AA@@@@A@@@A@@BA@@KK@@G@@@AAA@@@@A@@B@@A@@B@@@B@@@BA@@B@@@@@@A@@A@A@C@@@A@@AC@AA@@@AAACACAA@@A@@@@AABCCCA@AAA@ABMNA@C@A@C@CCOO@@@AB@@A@@@A@@AAB@@A@@BEAA@@E@AA@@@AA@@C@@B@B@@@@BB@@@@C@A@C@AA@@BA@@@A@@@@A@A@@@@@AB@AA@@AA@@A@E@@A@@BA@A@@B@B@B@B@@AD@DC@@@A@@@ABCBAB@@@B@@BB@B@@ABABC@A@C@A@@@@AA@@@@@A@@B@B@B@@@BA@@B@BA@E@ACA@@@@@AAAB@@AB@@@BA@@B@@@@C@@CA@AA@@C@@BAB@@@@A@A@A@@@@@@@ACA@@@@@A@@@A@ACA@@A@@A@@@AA@@@@AA@@A@@@@@A@@@@EAA@A@@A@@B@BA@@B@@@B@@AA@@@A@@AA@A@@@@A@@AA@@@A@@AA@@@A@@AAA@AAA@@@@A@A@AA@@@@A@@A@C@@@@BA@@@A@@@A@@C@@BA@@@@@AB@@A@AA@AAA@@@@C@@@A@C@@A@@@AA@@A@@@A@A@A@AAA@A@C@A@@@A@A@AA@@A@A@A@A@C@A@A@@@ABA@A@A@A@@AA@A@A@E@C@A@@@A@@AA@@@C@A@@@A@A@C@A@@@A@AAA@@@A@A@@@A@@AC@A@EAG@A@EBC@CBCD@@C@A@KGAAA@@@A@K@EAA@A@@@A@@@AA@@A@@@A@@@@@AA@@A@@@A@CA@@A@A@A@@@A@@AA@A@@@A@@@AA@@A@G@A@A@A@K@AAA@A@A@A@A@G@A@C@A@A@A@@@ABA@@@A@@@A@@@ABA@A@ABCBABAB@@CBABA@AB@@A@@@A@@BA@A@A@A@C@C@CBC@A@AA@@A@A@@@A@@@AA@@A@@@A@AAEAC@C@A@OCA@QBI@G@M@MBC@ABEDCBC@EAE@]@IEE@WASBQ@IAQ@MCG@C@CAAECEIEC@S@C@A@CFADBBBJBDFFDBBB@B@DBBAD@BCBEBCBCBKBEBCBABCBADCBCDC@E@CBEAG@EBC@EBCBABADABAD@DAD@D@D@B@FDBDBFBHBB@FBJDFBHBDDDBBBBD@BIP@@KJE@E@ACBCBCDCDCBG@E@E@KACAA@BB@BLNBDBD@B@BIJ@B@D@D@BC@EAGAEACBC@ABCBCFCDCBEBC@E@EBCAEAGAE@A@EDABCBC@G@G@E@G@E@CBC@CDEDEDCDCBGFGDEDEDCDEBEBCBGBG@MJEFA@EBE@CAGCGCECGCEAEAAACAAA@C@C@CBE@A@C@AAC@C@ABCDCBA@CAAAAA@CECCCAECEAC@GAC@G@EBG@IBGBC@EBC@AA@@AEAEAAACAC@CAAACCACACACACAAACAACGGCACCCAAAACCACAOCC@C@CDABCBEDEBEBG@EBE@C@C@AACACAE@A@E@EBI@EBE@E@E@C@C@EAAAC@CAAACACBC@CBG@E@E@G@CBKAsBM@SEcKIGCICECICCCIUAWBGCOIa[II_O]G¿WCAAAE@CAE@GACACAACA@@AA@EBC@EAA@EA@@@BDBBB@D@@@B@B@@AB@BIFCDABCBAB@@@B@B@B@BBBAB@@@@ABIHCDAD@DDHABGL@BBD@@AFAJCHCLABAD@BABABA@IFACC@G@KDABC@CAAA@AGGC@@AC@C@EBIBC@A@GCCAO@E@@BAB@BCBC@CA@A@@AAEAI@GB@@@BBD@BGBGAEAGAK@A@CHABA@CDADCBCBEBGAE@C@ABA@ABBB@BDBBDB@@BABA@@BC@EBC@GBGDCBI@I@ECECC@E@G@ABCBG@ABABCBGB@@@B@@AB@@ABA@@FAB@B@B@B@B@B@@CBAB@@@B@@@BDF@B@D@D@B@B@BBBB@DDHDBBBDBB@D@FDF@DBF@B@@@@@@DAD@BAD@D@DAFA@@B@B@DBDBB@B@BDBBBBDBB@HBBB@@@BAD@FBB@FAJBBBDFBFDFBFBD@TAH@D@@BB@@DBB@D@BA@CBEBABABBDBB@B@D@@@D@@B@DBB@FDBBFBJBLDDBDBBB@B@BAD@B@@@B@@@BBBBB@B@@@B@@ABA@AFABABC@IBC@A@A@A@CAA@@B@B@BADADCDABEDABA@MBA@C@C@C@A@CAA@C@C@ABCBC@E@A@AAA@A@C@A@CBE@CAC@ABCBCBI@GBGDEBCBA@@AICICGEAAAA@A@C@@CAAACAAACCA@A@E@A@AA@@@AACAAACI@G@WRGJEJILKHKHUHWDULKHKBiEI@GBMTEBG@U[G_CYBGBC@GFEFE@EAEECEMKGEI@]A@A@MAGCEEGWE]BK@IBUAMAgAOA_CMGCGEGAMAASMCA_CQC}IgKgUWGiEQEMIEAWImOSEKBMDUMIBEHEDADAB@B@BA@@@@@IAGAC@@@A@AB@@ADAD@@@BBB@D@B@BA@@BEBC@@@@BABA@ABE@A@AB@@ABCDCDA@CBAB@BCBCDAB@B@B@BBB@DB@@B@@A@EAA@A@ABA@ABC@C@AB@@@BAB@@A@A@C@ECEAC@EAC@@@@@@B@@@BBB@BBBCHB@FBDBBBB@BBBB@BBB@B@@@BADADCD@@UHjL^HLPHNRLPFPAXFTDFDB@@@@@BHFHFFFFDBDB@@BBB@@B@L@BBFBDBDBDDDB@BBBB@D@FBNDHDB@DCD@BAB@D@L@B@B@B@LEDAB@@@@BBF@BBDDHB@@BD@@BB@BDBBBBB@D@B@B@B@@@@@BB@B@BBBBBB@LFJDBBFFBF@@CB@BDBDDB@@B@B@@ABALBZ@TELGNEJO^MH@HJRBLCLCDMLMHIVGV[nINITELIJKZADFRENBP@FBLPNFLDLGHIJSHCF@BTTDLhXXJP@hMFBNNJNLTZTRRLNJR\\dNPVVJJLJXNTFVFXJVLLBVAJ@V@HDXBTAXFLHLLbXPHPNJJJLTRHHRTRHPFVDRDFJBJ@F@JGNABA@ADCBCBEBGDCBABCBCDEDABCD@DDFDBBBD@HFDBD@@H@D@F@D@BFDHBHBFBHDFBDBFDDDFDFBDDBDBFDFBB@FAD@D@BJFHBF@D@FBFBNFDBDDHDBB@DBDDDDDDBDDFDFDD@HDFDFDDBHBFDHBDDFDDD@BBB@BDDFFBDBB@DABAD@BAD@BBFBDBBBDBB@D@D@BDDBDDDDFD@D@D@FAHBF@D@D@DBDBBFABABCDAB@D@BDDBDFBB@PDD@DBF@DBDDFDFBB@FBD@FBFBB@DBBBDBDDFBDBD@H@FDDBDBBDDBBFBDBBBBDDH@D@D@D@D@J@HBFBDBD@FBJ@D@D@D@F@FBLBFALEHCBADCFAFCHBBBDBDBFDFBDDDBDBFBFDFDDDDBFDDDDBBBDBDDDDBD@BBDFBDDBBBBDH@BBDBFBDADABCBCBGBABAB@FBBBBDBB@JBF@DBDBBDDDD@FADBFBFDBBBBBBFDHBDBF@D@HAHAB@HBB@BFDFBD@DAFEDADAB@B@FBH@@BBFDFDDBDD@BBBBBCDCBADADDDB@FBDBBBBBDDBFDDBBJB"],"encodeOffsets":[[127270,54630]]}}],"UTF8Encoding":true});}));