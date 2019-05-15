(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('同江', {"type":"FeatureCollection","features":[{"type":"Feature","id":"230881","properties":{"name":"同江市","cp":[132.510119,47.651131],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@A@B@@BA@A@@@@@BA@@A@@@A@@@@@@@@@B@@AA@@A@@A@@@@@@@A@@@@A@A@@@A@@@BA@@@@@@@AAB@@@BA@@@@AAA@@B@BA@@AA@@A@AA@@B@@@AA@@@A@@@@@@A@A@AB@@B@@@@B@@AB@B@@@@@@AAB@@@@AAB@B@@@@@AA@@B@@@@@@@@C@@B@BA@@@@AA@@A@@@@@BA@@@@ABAAB@@@@@@@A@A@@@@@@AB@@AA@@@@@@@@A@@A@@@@@ABA@@@@AB@@@AA@B@@AB@@@AA@BA@@A@A@E@AAA@@@B@B@B@@A@A@@AA@@AA@@@A@@BA@@AA@AB@@A@@B@@BBB@A@@BA@@@A@@A@AAA@A@A@@@BA@@@AA@@@A@@BAB@@ABA@@A@AA@A@@B@@@BAA@@@A@AA@A@AB@B@@@BA@@@CA@@@AAA@@A@A@@B@@@BAA@@BA@AAA@@A@A@@@@B@BA@CC@@B@@A@@@@C@@A@@B@@@@AA@BAAAA@@@A@@BB@BB@@A@A@C@A@A@AAAAB@@@B@@@@AA@@@@A@A@@AABA@@B@B@@B@@A@@B@@@B@@BA@@@@@ABA@@AAB@@AB@@@@A@@AA@@@@ABBB@@A@@@@@@A@@C@@@A@@BA@@@A@@A@A@AA@@ABAB@@@@BBB@@B@@@B@@AA@AAA@BA@@D@@@@AA@@AB@@@@@AA@AA@CB@@A@@ABA@@A@@@A@@@@BA@@@@BAAA@A@A@A@@AA@B@B@@@AAAAA@AAA@A@@AAB@@B@@BB@@@@@@@ABA@@@@BA@@@AAA@A@@@@@@BABA@@@@@@AAA@@AB@@@@A@@@@A@@A@A@@@A@A@@A@AA@ACA@@@A@A@@@C@@@@BB@@BEBCDA@@@AAA@A@A@ABA@@AE@A@A@@@@B@@DB@B@@A@A@@B@B@BA@@@@AA@@AC@C@@B@@@BB@A@@BC@A@@@@@DE@A@@AAA@ABA@@BB@@B@@@@A@A@@A@A@AA@A@C@A@CAA@AA@@@@A@CDA@@@A@BAB@@A@@@@A@ABA@@@BAA@ACAA@@BABCB@B@@@B@@@@A@@B@B@@@@@AAC@AA@@@@@AB@@AB@@@@D@@B@@@@A@@BAB@@@AA@@A@AAAA@@BA@@AA@@AAA@DA@@@AD@@A@@@A@AAAAAA@CBCBA@@B@@B@@B@B@@A@A@@@CA@@A@AB@B@@@@@BDB@B@@@B@@A@A@@A@@@AAAA@ABCDA@A@@@A@@CAAAAA@A@A@C@@@@@C@EAC@A@ECA@A@@BAB@@A@A@AA@@B@B@@@BAB@@@AA@@A@ABAB@@AA@@B@@ABC@AA@@@A@CB@@A@AAA@@@BAF@B@B@@@AAA@@@AA@A@@B@DA@@B@@@AAA@CCCAEAA@@@AA@AAAA@A@AAGAA@C@C@AB@AAAAA@@@A@A@@A@A@CBABA@A@AB@@AAA@@A@@@AA@A@@A@@@A@@G@@@@@D@BA@@@@A@@@A@@@@A@@@A@@A@A@AB@@AA@@B@B@BA@@@AA@@@@@AB@@@A@@@A@@A@@@@B@@AB@@A@AABA@A@@AA@AA@A@@@A@@BAA@@A@@AA@@A@A@A@@ACA@@BA@ABA@@BAB@@A@A@@AB@@AB@@@@AB@A@@@@@AB@@A@BAA@@AABC@@@BC@@@@C@A@@@A@@A@@@AB@BA@@@@EEAAA@@@AA@A@@B@@@BB@A@@AA@AB@@A@@ACAA@@@BABA@@@@A@@EAAB@@@@@@AA@@A@A@@@@D@@C@@@@@@A@A@@AB@@A@@@@AABA@@@@@@@BA@@@@A@A@@@@@AA@@A@@@@B@@@BA@@AB@CAAB@@@BA@@AB@AAA@@BA@A@@@BA@@@@@AA@@B@@@@AB@AA@@@@@@B@@@@A@CA@@A@@BB@ABA@CA@@A@@BA@AAA@EDEB@@@A@@@@@@@AA@@@A@@@@@ACAA@BA@@@A@BA@@@@A@A@A@@AB@@A@@A@AA@@A@@B@@AA@@BA@@AA@@@@@B@@@@ABAA@@@C@@ABAAA@@@@CA@@@AB@@@@@AA@@@A@@A@@@@@A@@CAC@A@CAA@@AA@@A@A@@@@A@C@@@@A@@CAA@A@C@C@ABC@AB@@AA@A@@@@A@@B@@A@AA@@A@A@@BABA@AAAAA@C@@@A@@@@@BBA@@@@@@AAB@@@@AB@@A@@A@@AA@@A@@@@@@@BB@B@@@@@@A@@@@@@AA@@@@@@@@@@BA@@@A@A@@@A@@@@B@@B@@@B@@B@B@@@@@A@@A@@A@@A@@@@B@B@@A@@@A@A@C@@@A@A@@A@@B@@@@@@A@@A@@A@@A@A@@BA@@@A@@@A@@@BA@@BAA@@@@@AA@@A@@AB@BA@@A@@A@@@B@@A@@@A@@@AB@@AA@@@@D@@@BA@@@@E@A@@@@@@AB@@@B@@AA@A@CAA@@BBB@@A@A@CCA@AB@@@@@A@@AA@@@@@BA@@@A@@BA@BB@@@@A@A@@@@A@@@A@@AA@@A@@@@@@B@@@@AB@@A@@@A@@@A@@@A@@A@@AACAA@@A@A@ABÍBw@Q@AA@@@A@A@ABC@IAIA@@EAC@ECICECAACC@G@CDEFCLCFAD@BC@A@ABABABAFGDE@C@E@ACC@A@AFCBA@CBCFEDCFC@A@A@A@EAC@ABABC@@@A@A@A@K@MBM@M@K@UBY@a@[Bc@[@@@O@CBsBm@K@E@A@G@E@@@A@C@C@A@A@A@C@A@C@A@C@A@C@ABC@A@C@C@C@A@@@C@C@C@E@C@C@E@E@A@AA@@@A@AA@@AA@@A@A@ABA@A@A@@AA@A@A@A@AAA@@@A@A@AAA@A@@B@BB@ABA@AA@@A@A@ABA@A@@AA@A@AAA@A@A@@AA@A@A@AA@A@@AAA@CAC@AACAAAA@A@CB@@A@AB@@A@AAA@A@A@A@@@AAAA@@AAAACAA@@@C@A@CBEA@B@AA@@AB@@@BC@@AAA@A@@@A@A@AAA@A@@AA@A@@AC@A@AA@C@AAC@CA@AA@A@@@A@@@A@@@A@AA@@@A@@@@CACACAC@@@AAAACAACECEACCC@ACCACAA@A@AAE@G@AAC@C@AAA@AAC@AAACCCECEACGKCCAAAAAAAA@@A@@@A@A@EAA@A@CAA@ECC@CAEAA@C@A@A@C@C@A@CBC@GDKDCBGDKDC@GBCBEBC@CBA@A@CBA@A@A@A@C@A@A@@@A@C@E@EBC@A@EBA@EBA@A@CBA@CBABC@A@CBCBG@CB@@@@A@ABA@A@ABA@ABA@@BC@@BCBABA@AB@@A@ADCBABABCDADABABCDCDABCD@@CBA@C@C@@BA@A@CBA@EBC@E@G@I@G@C@A@A@AACAEAA@A@ECCACACAAAEAAAA@CAACAACACAAAECA@AAA@A@@@EAK@E@CAC@GAIACAA@QBQDIB@@A@A@C@ABC@@@A@ABC@@@A@EBA@A@A@A@ABA@IBIBA@A@A@CBA@A@A@ODOBABE@IBSDSDIBI@GBGBE@CBG@GBCBC@A@C@CBA@A@CBC@GBG@QDC@MDOBCBC@GBE@GBGBC@C@CBG@CBC@C@IBEBA@C@EBA@GBMB@@C@IBIBEBG@GBC@ABA@OBGBGBA@C@QDG@ABA@E@ABA@QBCBE@EBG@A@@BA@A@C@GBC@AB@@A@CDEB@BA@A@AB@@ABGDIDCDKF@@CBIFCBCBABA@ABEB@@ABA@ABGDABCBCBCBIFOJ@@CBA@CBCB@@ABABIDCDEBA@@BA@AB@@@@A@@BA@@B@@ABA@ABCBCBC@@BA@@B@@@B@@DDBBBB@B@@@BA@@@@BCF@B@@@@AB@B@BAB@@@BAB@@@@@B@@A@@BABABABABABCBABA@@BC@@BA@@@@@A@A@@@@@A@A@A@@@A@@@@@@@A@@@@@@@A@@@A@EAAAA@EA@@C@CAE@C@A@CAECEAA@AAA@CCCAAAC@AACA@@A@ABC@ABABA@@@@@@@@BA@ABA@ABA@@BCBEB@@A@AB@@@@A@A@@@EBEBA@C@A@C@E@@@@@A@CBA@@@EBG@ABE@E@C@C@A@A@C@C@C@A@A@C@A@A@C@ABA@A@@BA@C@A@@@A@@@@AA@@@A@@BA@C@CBCD@BCDEB@@EBE@EAC@ECAC@EBADAFGBA@C@ACCACCE@@@AA@@AA@AA@@AAAAA@AA@@AAA@@AA@AA@AA@AA@@AA@A@A@A@@AAAAA@CC@@@@A@A@AAA@A@A@@@A@A@AAA@A@AAA@@AA@AC@@AA@@@A@A@@@A@@@A@@@A@AA@AAA@A@AA@@EA@@@@AAA@AAA@AA@@AAA@A@AAA@@A@@@A@@@A@A@@@A@@@ABA@@AA@@A@ABA@@B@@@B@BA@@BA@A@A@AA@@@AB@@AB@@A@AB@@A@@@AA@AAA@ABA@@@A@A@AA@@BA@@@A@@@AA@A@AAA@@A@@@A@@BAB@@AB@BA@AA@@AA@A@A@@@@BAB@@AB@@ABA@A@A@A@A@@AA@AAA@A@A@A@@@A@AAA@@AA@@A@@ACAECGCGACCEEAE@CAE@E@IBG@M@@@GAA@@@CCIIEEAACE@C@EACAACAC@@@CBABADCB@@@@A@@@@@@A@@@A@A@CAAAA@@@A@@@A@@ACA@A@A@@BA@A@@@Q@IBMAGBE@CBCAAC@@AA@@@A@@BABG@@@A@CAE@@AA@@@AEAC@C@A@A@AB@@ABA@A@A@A@@@@A@@AABC@@B@@A@@@A@AA@@@@AE@C@@@ABA@@BA@AB@AA@CACC@@AAA@A@@@EA@@A@@AA@@@A@A@A@A@A@A@A@C@C@A@@BA@@B@@AB@B@@A@@B@@@B@@A@@B@@@@AB@@@BA@@B@@ABA@C@C@A@A@ABC@AAA@@@A@@AA@@@@@@@@A@@A@@@AAC@CAEAC@AA@@C@A@C@A@A@C@AAA@@@AAAA@@A@@AAA@AAA@@AA@@AA@@A@@@@@AAA@@AA@@@@@AA@@@@AA@@AA@@@A@A@@@@@ABAAA@@@@@@@A@@@CAA@C@@@ABA@@@@BAB@@AB@BA@@@@@@B@@@@A@@@A@@@A@@AA@@A@@A@@BA@A@@BA@A@@@A@@@AA@AACAA@CAEBA@C@E@C@ABA@A@@@C@A@A@EBA@AB@@A@A@@BA@@@AB@BA@@B@@AB@BA@AD@@@@@B@B@@@B@@B@@B@@BB@@AB@@AB@@ABAB@@ABABA@AB@BA@@B@@A@@B@@C@@BA@@@A@AB@@@@AB@@A@@B@@A@@@A@@BA@ABA@@@A@ABA@@@A@@@C@A@A@A@AAC@@AA@C@C@A@A@ABC@A@A@A@@@A@ABA@A@@BA@A@@BABA@AB@BABA@ABABABA@ABCBABA@CBABABC@ABC@ABA@ABA@A@A@@DAF@@ABB@DDDHHDNDZLPJJJDBBD@DBFBFBFDFFHHHHFTJHDJBHBP@L@HBDDDDBFAFAJBBLTFHBJ@D@D@DBBFHDFDBDDBB@D@BAD@HAHADBDHFFBHBNFLDDDDDJNHL@B@D@B@BABAD@@@BA@@BAD@@ADABABAFKNGPCH@D@FBBBDDBDDRDRB`DNBLBB@DJ@BDBBB@DDDDFFHFFDHpBVBZFlTLLDHBPAPA`@T@VDNHNRXHLHJVRjVTLVXNRFHFHBFAFCJalIPEVDXTVhPdB^AXILEZQbOXEZAT@^DRJNHVX\\bLLNPFLFFHHBD@@B@^LbJZF\\HjLTFRFXHVJLJPRDRHVJXNRPPXP\\NRHPFhLhJPBXBXBfAVAXC\\C^CbETGPENETCP@FCPITIH@VDTH~RNBjHXBXBXENGTEPAPA\\FTDZ@nEX@RDLBTHNLNTFRDPFN@HBNHVNLLFXHp@lK\\GXCtHRLRNNXJRDPBX@HFHZNjHZ@dFZLZPNDhF^@dF\\HjJjPVF`@\\AtDNDN_FK@CB@DEBCBCDGBA@@@@B@B@BBB@B@@@BA@@@@BA@@@@@@@@@@@AB@@@BA@@B@B@B@BBB@B@BB@@B@B@BBB@BBB@@@@@B@@@@A@AB@D@@A@@@AA@A@A@A@@AA@A@A@A@AB@@CA@@@A@@@AB@B@@AB@@@D@B@@AF@B@BCBAFAD@FADABC@A@AAAA@CA@AA@@AA@@AA@@C@A@CDCBAD@BAFA@@DCHIJKHKDCDCBCBADB@@B@@@B@BA@A@A@ABA@@B@B@B@BAB@@@B@B@DBBB@@BBB@B@BA@@BABCBABA@@@@@@@ABAB@B@@@B@B@@A@CBADABAD@B@C@@BB@D@B@BABAD@BA@@@@@@A@A@A@BA@AB@B@@A@@A@A@@A@@B@@@@A@A@@B@AAAA@@A@@BB@BBC@ABA@@AA@@AA@B@AAB@@AD@@A@@AABAD@@@@@AA@@@@BAB@@A@@ABA@@@@AB@@@@A@@@@@A@@AAC@@@@@@A@@B@@@@A@@DA@@A@@@@AB@B@@@D@@A@@@A@@@@A@@A@@B@@AB@A@A@@@@A@@@@A@@@A@@@BAA@A@A@@@A@@@@@BA@@AAA@A@@@@@@C@A@@@AB@BBB@@@@AA@A@@A@@B@@@B@B@@@@AA@@@A@A@@@@@@@@AA@AB@AC@@@@@BA@ACA@B@@A@@@AAA@@DAAAA@@@A@@B@@@@A@@CBA@@A@@BA@@E@@A@@@@@A@B@@B@BA@@B@@@@@AAAA@@@@D@@@@@@@A@AA@@B@@@@AA@A@A@B@B@@@BA@@@@@A@@AB@@@@@@A@AB@@@@@A@A@@B@B@AA@A@@AB@@@@@@A@@A@@@@@@B@@A@@@@A@A@@@ABAA@A@@B@B@@@@@B@@@C@@A@@B@@@B@@@AA@@AA@@B@B@@BB@@A@@@@C@@@BA@@A@AA@@@@BA@@@@@AA@"],"encodeOffsets":[[137317,49290]]}}],"UTF8Encoding":true});}));