(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('邯郸市', {"type":"FeatureCollection","features":[{"type":"Feature","id":"130402","properties":{"name":"邯山区","cp":[114.484989,36.603196],"childNum":2},"geometry":{"type":"MultiPolygon","coordinates":[["@@ACD@BACCCCECGGABCAABA@AA@AACCBCDBDBBFB@DG@ID@DA@CB@DCBCAA@@F@B@BC@@ACCABCB@COAACK@GA@DB@@AHBBBDB@@DB@H@@FHDB@FCBB@@DBBHDNDNJD@@@LAHBBHD@@@F@RA@C@@C@@@BA@C@CAA@I@@BAAKH@@CD@@CCCACCA@@@C@@A@"],["@@AC@@CAABC@A@E@@BA@@Y[@@@AKG@@I@ME@@BE@@@@B@D@DABAAA@IFEDCBAAAA@CGBBFGBSBCDBFT@BRF@J@FRHTBB@B@L\\@lETA@@F@@@@@H@F@RAD@@@@@@AAC@AE@@@@@MB[D@EA@@AA@BABAF@@@C@EGDCD@BAD@@@H@H@F@FAFA@EG@@GCDK@@BIBA@EBA@@@"]],"encodeOffsets":[[[117194,37347]],[[117265,37460]]]}},{"type":"Feature","id":"130404","properties":{"name":"复兴区","cp":[114.458242,36.615484],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@GSEQI@E@AQS@A@U@G@@@@LA@A@AC@AGBCCEBBB@BI@@AAB@@@@ACCAABBHA@@CE@AF@LBBALABCB@BHJNJB@JB@@BCL@@BB@FCBHB@CF@LKFC@@BCDBBDBF@DF@FB@@@B@@BAHAD@B@FE@@D@H@HJHDBB@HAHANADB@DFDBAR@BBJ@BAPACgAQAS@MAE@K@AAA"],"encodeOffsets":[[117222,37475]]}},{"type":"Feature","id":"130403","properties":{"name":"丛台区","cp":[114.494703,36.611082],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@J@@I@@B@@IG@@@@@E@@@SBkF[@BF@NBTBRDh@NB@BLNAD@@AF@F@@FJ@@FHDF@B@AE@AEA@@@@@A@A@CB@@A@A@AAAF@DCFA@IF@FGDGBG@AH@CC@@@@@@AA@@@@@@@A@@@@@AC@@MB@@@@@@I@@@@AE@@@@@A@@@@@E@G@@"],"encodeOffsets":[[117270,37489]]}},{"type":"Feature","id":"130406","properties":{"name":"峰峰矿区","cp":[114.209936,36.420487],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@BBB@@GBCBG@CGCKAGC@GBAHBHCHK@IDA@ADM@CAGCEAAC@G@I@CBAAAGBG@GFAACBEACD@BAF@DAB@BDLABJ@BDABCF@NAHCBADABG@I@GLABCEAEBWAKBACG@@E@AHACGOCOGGGIOKKQGOCKGGII_AMAOGMCOAMBKAKIKKCMBMBQHSHOHQJODODQBUBQHCLGVEVEZEX@V@XBX@VAVBJI\\EF@@FBLAD@@D@DCB@DAFC@Q@[Ba@AB@B@@IAC@ADFFFDBB@DCBBB@@B@B@@BD@B@B@BBB@B@DB@F@BDHH@DBBBFDJAFBBDDH@FKHAF@FBBCPDLBBBBPBHADABAFC@A@@@@@CAEBCBCDAP@J@@BAFJPBFFADBBFDCDGF@D@FCBEAKAIBADAH@BBHBLABAJEPE`ETBVHTFRDDFHHBBHA@D@@HAB@F@HAB@@EDA@C@@NA@AAEDA@E@CDCDDBBDB@H@DF@T@"],"encodeOffsets":[[117025,37428]]}},{"type":"Feature","id":"130423","properties":{"name":"临漳县","cp":[114.610703,36.337604],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@MaEK@C@@@@CM@QDOJMHI@@@C@@@ED@AMA@AEA@@AAKA@A@A@@@FA@ACID@NLBBBBDBBCHGBA@ABCDE@ABADGCQCG@I@ADEDGFCD@AACGGCKBBB@BGB@IBICCIDE@GEAC@AGB@@CB@DMBEIAA@@AAG@@ACA@EE@@EAAOBBFC@@BIBI@BFG@AEI@AEAISB@CG@@D[BQ@@AA@@AKB@CM@@@A@@AEA@G@@@AA@@CKA@A@CE@@AGBACEB@FI@@DG@@CAA@DCA@C@@AE@@@BA@@@A@@ACB@BAB@@@AE@@AA@@CIBACABCAAAEDA@CBBBBLDAB@B@@DB@@@D@@B@@@@@@@BA@@@@@@BE@@BA@@B@@@F@@@HIB@@E@@BE@@DGB@FG@@FKBG@@CA@@D@@AACB@@CBBBEBCB@@EHQPcH[@SBQFMJKLGLGJKFODSAWB[FGJANGNUAKCMBMBCBA@MBA@@HGB@AACGDEB@H@@@FA@@HA@@DC@@BEBABA@@J@B@BC@@FRBANBBVFB@LDDFFBJ@HCF@DB@TB@F@BJAJ@BRFCX@FLFJEF@H@JlDDF@@FA@A@@@@NA@C@@F@@B@J@BHNA@DF@@N@VANB@B@F@BAnADAACb@BBBRDADR@@BN@BB@BPE@CGCCA@CF@BBDBBDHFAJ@@APBB@DA@EF@ASAMJFH@LA@FA@@@BZV@TADB@A@S@@BBZ@RE\\GFMCMBQLSL@BBJABNJAVBB@@FD@L@BAAMF@DA@@B@JA@CZCBLN@BNRABDdA@EH@LBAGBAPC@ED@AIB@F@@HLAB@ACLABAACD@D@B@@KCWP@@AF@@ABAP@FA@AF@@BBBP@BA@AAGF@H@B@@ECYAAA@IBA@@EEBDM"],"encodeOffsets":[[117508,37166]]}},{"type":"Feature","id":"130424","properties":{"name":"成安县","cp":[114.680356,36.443832],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@C@OCWAUCQCQDQRETANCJGDIAKIGOEQEO@QAMAQIIKB@DAACBE@AD@@@C@@@ACDAAKAAE@CMC@AIHAAGCA@AB@GMIIOOKMIMIMMKSKQIYECNFA@FB@JAB@BBDZ@FA@G@E@BH@BABO@AA@AE@@BEBO@AB@BE@@BO@DX@LA@C@C@BDABKBBDA@KB@GE@A@BJC@@FODABBHKAG@@FcBACQBAMM@AKYD@DIBA@@@CBE@BNABK@C@@EA@UAIBAMIBAAK@KTARDNEN[HQFY@AA@@@T@BCASBU@AY@@B@@EKBG@IEBNBTE@@FCBA@OA@BI@EBBFBPHPFNB@HL@@BBDNBF@DN^HJAJEdBDF@@BHBF@DABCD@NBDBF@FADEZUNAPBNBT@VETI\\AZL@LdGJ@@@FFDFD@H@DBLFBBL@BDD@@CF@LAH@FBD@D@BADALBL@FDBD@RBBF@ZA@@@E@ADAH@DBBDFDT@D@BAFCBA@E@@F@B@DABAP@\\DN@XBT@XBV@PAHQ"],"encodeOffsets":[[117617,37367]]}},{"type":"Feature","id":"130428","properties":{"name":"肥乡区","cp":[114.805154,36.555778],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@EC@A@A@AAACB@@CAECE@E@ACAAAEE[@AC@I@AA@IDABAAMB@@DB@D@BI@CE@AEGCCAAIO@AAAGCM@@A@CIKB@@ACGBC@CAAAAEAGKBC@AA@AGBABC@CEA@@@GC@AH@L@DWGCCECACEEBA@BDABWAGBACAQG@@EG@ACCKC@EA@EC@K@ED@B@LEBCF@@@BKFM@OCQEQAGROBU@WAS@WAM@[CO@ABCBA@E@@@@FABEDABC@S@ECACCAG@CB@B@F@@YBE@AA@QACECK@KACBABC@C@EAG@KBE@@DC@ACK@AAKECAG@C@CEEE@@I@cHANINENHJHH@@JHJLBLET@BE@ADI@AH@FC@@B@FB@BJCDMD@@@B@BBHDAD@LDJ@@FP@DB@D\\@BFDF@D@DDJNFDFJDFADEAIHANA@GH@J@BPDBJPHTLLNLrT@@@@@@B@@@@@RJXJ\\LB@@FF@BFVBFBALNB\\BJBBFN@F@HABJB@BFJCNBNADAJE@E@AB@D@@F@BVAFBDARADA@A@GE@@EBCB@@KDEB@B@HANAFDH@DAAAPAJANDBHJGJAAEF@@@DAAE@AHABDR@D@AEHAFB@BBDDB@AAAF@J@FF@D@@F@FCFABCFEJAAGBARETEJI@G@ABAD@B@"],"encodeOffsets":[[117799,37490]]}},{"type":"Feature","id":"130425","properties":{"name":"大名县","cp":[115.152586,36.283316],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@GDGDEHEBEBI@GDEHMX@TCRAVC\\CZCLANAVATKNONKHGHGJILIHWNGNEP@F@DINABQA@F@DABAI@@C@BFABA@MBBHQ@@JB@D@@D@@C@@D@BEDCBEFEL@DB@@F@@E@BFNAFDJDBD@HBBBBB@T@H@@CDABFD@AI@AT@DBAED@NBFNBBFBBBADB@FBBADBHDFJ@JHNTNRFHHHHJHTFPBZCNKJI^IPENCVSTEV@NBNANAPGREX@ZFRFPJTNLJDBL@@@B@B@@A@A@@AAA@CAAA@@AA@ABABEBC@@@A@A@ABAB@B@@@B@BD@BDDBBBBB@B@BAFCB@@@B@@A@@@A@@@@AC@BAAFA@@B@@BDA@ABAB@B@@@@C@@@@DA@CA@AAFAAGB@AEB@AGA@@@BA@@@@@AC@@AD@@GABG@@@CAAAAAAA@C@CAAACAAA@CAAACAAA@A@A@A@ABAB@BALEPCVCPEPGLODKBY@A@@@@@@@@@OJKNOPMDSGKGEEIBOLCNFLDNHRJhHPEBCCEAC@@B@AIA@@AFBAC@AA@@ADAAGDA@@CGA@@CA@@AA@A@B@AEB@@CDAAAB@@AJ@@AF@@CF@AC@@@AB@@A@@@A@AD@HAACTCBDDA@@BADBFDB@D@B@D@B@BA@C@ABA@AB@@@@@@AB@@ADA@@B@AEB@@A@@@BB@ACDA@@C@@C@@@AA@@@@@@AA@@B@@AE@@A@B@@A@@AC@CB@@AFA@@D@@AH@@@B@ACD@@CBE@EAM@I@OBIDI@MCMAEBKH_FmIBKBEDEHADAXABKBGACAAAAK@Q@EACEAE@IBI@EACCKMECIAEBCB@@E@@DA@@DCA@DBBBBDDB@EBBD@@@B@@@BA@@DCB@DB@@DB@@@C@@@@ACIA@AC@@AGC@@@A@@@BAA@HEAA@AB@ACA@AC@@AABC@@C@AECECAG@Q@CAACAICWEKGGKGUIKEC@EBGDA@GAKEIBKBIDIJKR@F@DDHFT@JAFEDGBSDIFEDGLMRCHAFETU^OJUJODIFIFEBIA@@CB@AA@BDA@@B@@@B@@@B@@@@F@@BEA@BL@@BKA@@A@@B@@@A@@@B@DEAAAA@@ED@@AA@@A@@@@A@@EC@@EEB@CC@AEA@@AC@A@@@AAABACG@E@ICGBMBEDAB@DBD@DEHGDMDG@]B"],"encodeOffsets":[[117888,37080]]}},{"type":"Feature","id":"130429","properties":{"name":"永年区","cp":[114.496162,36.776413],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@CKAAA@AADQDAD@BC@IBKGKKGOCSAMASCMOL@@EBCdCB@@ABCJ@@EJ@@IEB@E@AAI@@B@FMFGLENIFM@M@KDMBINOTCTAXAX@RALCTENAFABAJG@ADAB@FBHAFAAIB@F@@E@A@@@@@@@CCEE@CAAA@AB@@A@EBAAE@AA@AA@C@@A@ABA@A@AA@A@AA@AB@E@@@EHA@@@WAAAAE@CM@@EC@CB@@C@@@@@@D@@GDGH@@BB@@QA@I@E@MGAAEKF@AEA@C@AEFCAEA@AIGBE@M@AEIA[AMABKEAUAAEE@@EA@[KWIQI@@@@A@@@@@@@qSMKKKGSIOCAAOI@G@@HMBGBBJCFEBICCEMECI@C@CCEAE[@@DC@BDABGBCHCT@LABG@@FA@@JK@A@BLD@@@DRHHHBBLBNA@A@GDA@@L@@B@BAD@DB@DA@@D@N@HDDB@@FN@@FABA@@BABCBC@ABGBA@C@C@AB@BCDA@ABA@IAC@C@C@@DL@BD@NC@CB@BBDE@CDIBEDCH@HABMNCBQD_DWDUB[C@@IA@CAAEBABE@@AQMIEE@@B@B@C@AAEACA@A@BFA@IBK@@B@BG@@B@@@@BDC@@@@B_AU@MAc@kCoIQ@@CACI@IAK@@CCAE@EB@DEDIBAAACEJIH@D@FFHDBBBDDBJJPNFD@JFFDDFFFDADNDB@B@FEJ@FBNABEDKBCFAFABA@CBFBBBBDBDBFBDHJ@VDbADGLU\\P@\\CRCLEVCB@BB@FBBFA@GFBB@BEB@FAP@D@BDBBF@HAH@JB@FFDF@P@@E@CDAFAL@DIHCB@HARC^ETDjNRFNHDF@BAFDJ@P@BC@A@@DBHEB@@F@B@BJCHC@@BAD@DL@@@@FDDPA@FTAF@B@@JF@DAF@@CV@@CDADBD@FHDDV@B@@AJ@FF@FPB@GF@R@@BFB@FJ@@DDBJ@DJB@D@B@DF@HHA@AB@LAXAD@DBDB@DB@NBDFCDBFFDF@BD@FF@@JDBHAL@@FBDD@D@BA@EFCHABGD@LADA@CF@F@@E@@JD"],"encodeOffsets":[[117519,37814]]}},{"type":"Feature","id":"130426","properties":{"name":"涉县","cp":[113.673297,36.563143],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@JEHCDABCFGBA@C@C@E@@BCDABOFUDM@IEKCQDMNCXFPDZEVERCRCV@PEHKJQFSFSLQNONILMFMDMCIIIGGBIHIBK@OKWIQGOKSKOOUAIHM@@@@BAPINCFGAOCQCIEWCO@@AO@QBELKHAFFFJNPBLDJFLNHP@PGDODSDKHQFONGPEJEHCPGNACOGGIGOEGG@MAMGKIISKKCIGCK@IDKAGIIMGMCCE@@CAA@AAAACEACAA@ABEBCFAHABACCE@C@CCACBED@D@HDBABBB@JEB@DBB@LCDABAB@D@B@B@D@BBB@B@BAB@FAD@D@FDDBD@H@HAB@B@B@BB@@LENEAA@C@ABC@CBCBC@ABA@AB@B@B@D@@@B@B@BB@B@@BBB@B@B@BADA@@@A@@AC@A@A@A@AB@@AB@B@B@F@BA@@BA@A@A@AA@@AA@@@A@C@C@CAAAACAC@CBA@ABA@ABAB@@A@A@AA@@AA@CBC@EBCBA@AB@BABAD@F@BAB@BADABADABCD@@CBCD@@AB@@@BB@@D@B@@@BADABADADADABCBEDABA@@@A@C@@@A@@@A@AAAAC@AAAA@AAC@ABA@ABAB@@AB@B@B@B@B@D@D@DAD@@A@@@A@@AA@AA@@@@A@A@AAA@AAA@@C@A@ABC@A@@@A@@@EBEBA@C@A@GCA@@A@@@A@AB@@A@@@CAAAA@@@MCCKCMCMAEB@FERITGF@@@@ABC@AB@BA@AB@@AD@BAFAB@BA@A@CBC@@BA@@@EA@@A@A@C@C@A@A@A@AAC@A@C@C@CAE@CAA@C@AAAAAA@C@A@ABA@A@@AA@AB@@ABA@@@A@@B@BA@@D@BAB@BADA@A@A@@A@AAA@A@C@CBGBCBE@EBA@EBA@A@A@AAA@A@A@A@AAA@C@A@CAC@C@C@A@CB@@AB@@ABABAB@BAB@@A@@@@@A@@@A@A@@AA@A@@@A@@B@@@D@@@BA@@DAB@BABABA@@BA@A@C@A@ABA@AB@@A@A@C@E@AAA@ABA@@@A@@@@B@@@BBB@@BBBB@@BD@@@@@BABAB@@A@@@A@@@AAAA@@ACAAA@@@A@A@@@A@C@A@ABA@A@AB@@A@ABAB@BADA@@B@@AB@BAB@@A@ABC@A@C@AAA@C@AAA@@@AA@A@A@A@ABCB@@AA@@AA@A@@@AA@@A@AB@@A@@BC@A@A@@@AB@@@B@@BB@@BB@@@BB@@B@BA@@@A@A@@@@B@PCRGPMREREPIRY@M@OAUFUNIHIJKJQLKFWFS@M@M@MHELARANCBA@EBC@GBIJCBK@GAIECAAB@DBFJBDB@LDD@F@F@B@DBBFJ@D@B@F@DAD@DB@DCD@@FABG@GHGAGBCB@H@BDDDADEDA@@FBDDLFD@BBB@D@HCDAF@D@D@BBDBBDBBBDBDBFAFANKLINGHGLMHSASDGHDLDPDRANQLUBOBO@ODODM@OLGLDPHNLLVTJHDNHRAPQ@OEMEMASDCPNRLTJLPLRFZGNARCRCLNBLLPLDPDLDN@N@PITAVJRLRJJHPLRJLFRDR@PFCPIRFRJHDJGNGNCNDVLJHHHJDNJLLFPDBABABCDAFCD@D@BBD@BBD@B@DCBC@C@EBCAA@E@E@G@CFAD@B@DA@A@CBABA@ADADBBADBD@B@DDBB"],"encodeOffsets":[[116485,37739]]}},{"type":"Feature","id":"130430","properties":{"name":"邱县","cp":[115.168584,36.81325],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@C@CD@B@@FD@HIBEDADAHUBCMCQCGEBIJONKNILEJCNCPBH@D@@@FDDBJA@I@EFA@ABUH@@AAAIGCWA@I@CACC@GDIDAFAN@LBBFDDHFLFXNRBPGbD^C`@VER@RFPF\\DZAOUIOEIGQ@OHQLWLOHKDIDQDI@KMOIGIMBUJSFS@KIGA@CIEAGBCAC@@CQDAEE@ACJABACO@ADGFCBALALK@CAGCEAACAC@UFCBBFKDBDEBBDABEBEBBDCBACC@@F@@C@@CE@C@ACACCBU@MGMGGEGKBKBWAMKMQCAPCJEJILQNQFKHGNCLEPINIFOBW@S@U@CNAJBR@XAVAJANGHOBOFAECF@DCBC@BH@B@D@B@BABCF@D@F@DBJM@@@@DAC@@@@@@GA@@@@@@GBDHHBHHJ@BBBDF@@RCDCBMBGDEDADAHAD@P@BAE@@@B@NFA@LBBB@TAJCTA@BADADH@BJF@BFG@CD@BB@@DGDEBK@AAE@GAI@CBGHG@CB@@@HEDEB@BGBA@R@@BC@BDEAA@@CABCAEDABAFADBLB@B@BJBBDDHDBBDNA@ABFHDFBBBBFFLABJBBF@@BBA@FL@@VDTFLBDB@BF@@D@@BD@"],"encodeOffsets":[[117870,37847]]}},{"type":"Feature","id":"130427","properties":{"name":"磁县","cp":[114.38208,36.367673],"childNum":2},"geometry":{"type":"MultiPolygon","coordinates":[["@@@GCA@@CAAAGA@BA@@CHBL@BDPB@DDABADD@BD@@A@A@EB@DBDA@CDAB@@CJCH@@CEAAAACDCDABD@BBBB@BADBBAHHFDDDDDABC@BD¸iAECMAA@@GKA@EMGOAOAECGAAAC@ADEB@DDDHF@AOA@@AAM@@CQCBAQAAa@BDCBmBABE@A@A@BM@U@ME@@CMBAGI@A@@@@ED@B@@M@@B@B@@EE@CCIkG@E@IFKE@EDWQE@ABIAIE@A@@SCAE@GDI@EACEKCA@UEAABMQASBK@@CAE@EG@A@ABABC@CBEBAAA@A@AAA@@AA@@A@@@AB@@A@@E@G@C@A@AA@@IBE@AB@DMFSDGDAB@BCBEDGDC@CBA@CAAA@AACAA@AECECCA@@CAA@C@CBADELCDIHADADBBC@@@A@@@A@A@E@ADC@C@A@@@CIBA@@@CCE@@A@@@@@CE@A@ABA@C@@B@@AAC@AAAAA@A@AA@@A@@@@A@A@@AA@ABA@@@@B@@A@A@ABA@@@A@C@C@A@@@A@@BA@A@@@@A@@@@A@@A@@@@@@AAAA@A@@A@A@@@@@A@@@@@AA@@@@@@C@BB@@@BAAA@A@@@@@@@A@@B@@@@AB@@@@@@B@@@@BA@A@@A@A@@@A@@@@A@@@A@@@BB@@@@@@A@@A@@A@@@BB@B@BB@@A@@@BB@@@@@BBBB@BA@@BBB@@AB@@BD@@@@A@@@@@@B@@@@A@@@@@B@@B@@@@B@@@@BDB@BBF@B@B@BCBABC@CBA@AAA@@@@BBD@@A@@@AA@@@BA@AEAC@@@@@@@B@B@@@@@@A@A@A@CB@@@@@@A@AB@@@@AA@@AB@@@B@@@@AB@@@@@@EB@BA@@A@@AA@@@B@@@B@@@@@@A@@@@@@B@@ABA@CBA@@B@BA@@@A@@B@@@@@BA@@A@@@BA@A@@@AA@@@B@@AA@@@@@@@@@@A@BA@@@@A@@@ABA@@DAB@@A@@@@@BC@@@@A@@@ABA@@A@@@@@@BA@@@@AA@@ABA@@@@A@@BA@@@A@@AB@@@A@@B@B@@A@@@@A@A@A@ABAB@@@A@A@@BA@@@@@@A@A@@@@@@A@@A@@@A@@@@@ABABA@@A@@A@@@C@@@A@AACBA@A@A@@A@@@A@@@B@B@@A@A@@@AB@@C@A@A@A@@@A@C@@B@@A@@BA@C@AB@A@@@@A@@@@@A@@AB@@@AA@A@@@@@A@@@@A@@AA@A@@BA@@@@@AA@A@A@@A@A@@@A@@@@AA@AB@@@@BBA@@@AB@@A@A@A@A@A@C@@@A@GBMH@@@@@@A@@B@@@@@@@@@B@@@@@@@B@@@@A@@@@@@@@BB@@@A@@B@@A@@B@@@@@B@@@B@B@@@@A@@BCB@@@BA@@BGF@@@@ABAB@@@B@@A@@AA@@@@@A@@BA@@A@@@@@B@@@@@BCB@@@@BB@@@B@@BB@@@@@B@@AB@@@@@B@@A@@@@@AA@@A@@@A@@@@B@@A@@@@BA@@@@@B@@@DBB@@@B@B@B@@@B@B@@@B@@@B@B@@@@@@B@@B@@B@@@BA@@B@@A@@@@@@BA@B@@@@BB@@@@@B@@B@@B@@@B@@@@@@BB@@@@@BB@@@@@@B@@@B@@@@A@@B@@@@@BB@@@@@@BB@BBB@@B@@@@BB@@@@@AB@@@@@@ABA@@B@FAD@DABAB@@ABC@C@A@@ACACCAAA@A@ABC@@BC@CAI@E@@@@AA@@A@@A@@@A@@D@B@B@B@BBBBBBBDDBDBD@B@B@D@B@B@B@BADADABABA@CBABA@A@A@C@A@@AEAA@AA@@@CBCAC@AAA@@CAAA@@C@@@AB@@@@A@ABCB@@AB@@@BABABABCBCDCBEBIFEBC@C@A@AA@@MFKF@@AAA@A@A@GBG@C@CAECC@C@EBA@ABA@A@AAC@A@A@C@A@ABCBKDA@CAA@IFA@AAABGCC@C@AFBDDDD@F@DDABGBEBADAF@BBBBDDFBBBBB@DB@@DFNDNHJJBHCL@JDLJHLDTLJJHLBN@NHHPFJHHHDPDDDJ@@BBBD@BD@DBBDDHFHHDD@BABAFCDEJCBAFBDAH@BFDBB@HFL@FEB@BCJCBD@D@BDBBJ@BDADBA@D@JB@@@ABAb@\\AR@D@BE@CDA@C@CC@KBEA@@FEJ[AIBU@UAW@W@UFWFYFUHUDKRGVARAPCPCRIPGTGRGNANALDJLBLALBNDPHNBPBNJ`HJLHPDRHLLJPHHPHPDDHGB@B@FH@BDLAXBFAFBADKB@H@JAHCBþ@"],["@@B@@@@D@@DBBDDD@DC@@DG@BLAB@@@JBB@D@DAB@@D@@@@DQBE@@@C@AGGAKB@@C@MIMCGCAA@CA@DA@ECAEG@@ý@ABGDMBE@ADCB@AAIKBACA@CBE@ABC@BDAFBDEB@HAHBHBBDAJ@H@D@BBDFBH@DCN@BCB@JGLGDGAAB@HHDLBHD@DAHAD@HA@AAADDDH@DADBAD@REFENBDNFCDADF@JFFB@FBBHADCNE@@@@BA@@@ADB@@B@D@@@B@B@@AB@B@@B@@D@BB@BBBFBBARADADCHCAMDCDMDADEHIDANAVIH@DAACB@REACDC@GD@@C@CN@J@DAHG@D@BD@BJBDFB@F@HDBLDHA@@@CDAB@@D@BPA@ACCB@FAFBBADEAKJAACCG@@@AACH@@DBBPABHF@@FFBHA@AF@@@AD@@H@@@AEB@rCB@@EBC@GF@BEB@BCD@AC@@D@BAFCBGBKA@CBGA@@DCBA@AE@ACFcBIGIM]@C·j"]],"encodeOffsets":[[[117146,37354]],[[117194,37347]]]}},{"type":"Feature","id":"130432","properties":{"name":"广平县","cp":[114.950859,36.483603],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@DAAECEECAAAG@MAQAMAAABAA@@FA@AK@C@ACI@@KK@W@QIQOGWEYYDOASEIGGGGGQESMGM@IEIGCCAABEAA@BCAAEAAAEMMAC@BFCAS@@BBJC@AECB@DG@S@A@AAAA@GACICECMBAE@@@FABABC@EFAAG@IABAACACAAMEC@GBDBEFEBEAEA@AC@AA@KCGG@AECB@DKB@BM@CACAAOBAD@AEDADBBBAEF@D@B@AGCUF@BAEAG@EEAC@IGEEA@AD@GCEEIAKBGABHC@@AA@C@@BA@IB@FE@@HSB@DE@CEEDA@CAACCAGBAIC@IDABBDAB@@C@@BAFBDCBA@JLRJNBRBP@RFPFJHBLCJIHMDSBQFCRDRDRBVDX@P@DRBRFPDN@LE@A@@DEFA@K@AFCL@D@@FFBD@DLBDH@@FH@BRBDHAXBBAACB@FADFDBDFHDCXK@G@@BHD@@B@DFD@BAHA@BBBD@LABHBFBBDBD@HABD@@LADJB@@@DNBHBBP@BJDBHDBFF@@DAJC@A@@CA@BNABCB@JBBJ@D@@BF\\BFBBBDF@F@FDDB@@DABB@B@B@BFDB@J@@ET@BGD@@EF@@C@@@A@AB@F@@BB@D@DAB@@AD@AEFAF@@DDBHAA@DADFFA@B@BFADAF@@A@ABBDB@A@A@ABALA@@FR@JL@LA@CD@B@TCBHHABHD@DADTBHB@F@J@@DB@@C@@DA@@LCAEAED@ACC@AEECI@CB@@EC@ABAAI@CEBG@A@AIJEB@HBD@@EFCLAVCBFF@DA@AFCJA"],"encodeOffsets":[[117947,37456]]}},{"type":"Feature","id":"130433","properties":{"name":"馆陶县","cp":[115.289057,36.539461],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@ACCCCC@@AAAAA@C@ABAA@@AA@@ACBA@@@@DABAB@@AB@AA@@@AC@C@C@@@AAACAAACD@DA@@BAAACCAA@@A@A@A@AAA@A@@@AA@C@A@E@ADA@@BAAA@@CAA@E@A@@A@@AA@ABCBABAAAAA@@@@A@BC@AC@@@@@A@AFCAC@A@@@@@A@ACCAAAC@A@A@EAC@C@@@@A@A@C@CA@@AAAC@AACAAACAAE@A@A@A@C@AAA@AAAA@EAA@A@EAA@CAA@EA@@C@AACC@@A@@A@A@@BC@ABA@@@A@A@@@C@AAAGEACCIACA@AAAACCCACCACCAAAAAABGB@BC@EFA@@E@AACAAACEEGEAABAHEDAA@AAA@GACAAA@@AC@C@C@A@AJ@L@@CAEIBCGKDACAEAC@ABE@EAC@CAGCG@C@E@C@E@A@C@AAA@AAACCAAAAAAAAAACACCEAAACAAAAA@AAAACCAAAA@C@CAA@@B@B@@@D@B@B@BA@ABA@C@@@CAAACCCA@@AABAB@@A@@@AAALAB@@@A@ACACAA@CBA@ABABA@ABAB@@A@A@CCEACAAAACCGB@DA@AA@@@AA@AEQD@AAG@AA@BA@@B@@E@@@BF@@A@@@AF@F@D@@A@C@A@AAC@A@A@AB@@@BAD@CAKISMOIQEYEW@QFOHMBMBMAU@SFUTMDOF]JIJMLFZHXRPRJX@L@@LJ@BDD@L@@BEB@@BBBABBBNBR@NBHBBFDDFBFCB@@BFRADJBDHFDNDHBDRHNJANWFCRPDPBRDLNBNAXALHLHFNHNHV@DABDBDD@F@@DD@@@@ED@BDDAACFAFABAACFAACLCAEDAVED@DBBBDFBH@DKLKBABEDCH@BDPABIBBDF@BFRC@DD@DBHAFBDJB@JH@LETITAVJNJHNP@LFABDFDLADFBFBDB@D@BAFKH@BCACFE@CF@B@JAACJ@NIJGNENBRBR@RA^CTEPCLCRK"],"encodeOffsets":[[118246,37625]]}},{"type":"Feature","id":"130434","properties":{"name":"魏县","cp":[114.93411,36.354248],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@F@@@@EA@@CFKFEDAFC@A@CD@@@@CC@A@@IR@AGNAB@BAAED@@@BJBA@C@ERBBAJM@C@EFOHMXMJGJKHIHGLGPMLMBSBUBMDKDYD[BUDQ@SNWFGHCJ@FAFAFGHCHCICGCEECGEQAMASACCAG@aJYFG@EAEEECQWAE@EBGBC@E@EGYAG@GDIBAAE@A@A@AA@ECCACCEECAGGGGIIKIAAECIICCCCGGCACACAA@AAA@E@G@EBA@A@A@C@CBA@AB@@ABA@AB@@A@AAA@A@AAA@GAA@C@A@A@AAACACA@A@A@C@A@C@AAACAAAAA@CAA@AAAA@C@A@AAAAAC@E@C@A@CAA@@@C@ABCB@@A@@B@BFPH^J^@HCLCHGDIFCFAFA@@BCDA@BFA@B@A@FR@@DLBJD@@@CB@@IB@AK@GAIBBFB@@@@@@@A@@DA@AAA@@@AB@AMB@AAAE@@JA@@@ABAEA@@@MBACE@BAE@A@E@@CA@AIB@AAD@AQO@@B@@@@G@@B@BA@@BG@@CA@A@@BEBACCBC@AEE@@ECBACIB@BIDI@@@A@@DA@E@BBEB@DAB@AA@@CK@@CIBBDG@@BI@@@G@AIK@AGKBA@BLEBBFKB@BABIBBBA@BBC@@BDDCBBDC@@BCBBDA@@BBDHFF@JCDDAJ@JHA@AAALAHDDHBBC@EDCHCF@B@JDHDRCHAB@BCFAD@BABGHADCAAAAAMKC@DJ@BEB@@B@B@B@BL@BB@BFB@BNC@@F@@@D@@GJINCP@RDN@@@@@DFLNbZFRJTLNLJNJNLNPPJJHNA@@BDBBHGBBJD@DNF@BBBLCBBD@@D@BAACBAJCD@BJHADBBDDBB@FCDFF@@CTA@GF@@EJAB@@AD@B@@BD@AGHBLAJBFFHDC@@BFBHF@JBDFFH@FBABE@DVBHA@C@E@BFAACACBBFC@ABBPDBDBN@@ALA@CDABFH@DH@LBBD@@BFBFBFAFECAHAD@NFBBBDBDABJBH@BBFED@BABA@E@@"],"encodeOffsets":[[117736,37307]]}},{"type":"Feature","id":"130431","properties":{"name":"鸡泽县","cp":[114.878517,36.914908],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@BOB@D@BCBIAK@EACGCAGDA@EI@AGBAD@@@AI@CFCFBAI@E@AEBAGB@@@BCCCKBA@IBEE@GEFAEAGBAD@CGA@AE@EFCNECME@AOE@@O@@FA@@BEAECIEBACC@A@@EHMIMMQGOEOEMIQGG@@BCHA@ABEB@B@D@@C@AC@AAAI@@CEACCAICEAA@EBC@G@A@AA@BA@@BAB@@@A@AAB@B@@C@@BAHBDODAAAE@CA@SBAB@F@BA@@BBBDBF@DF@D@@@@@@@B@FE@A@BJEBGBEAA@CB@BIHABEBMBSFKDQBW@WBSBSDMPAJCN@L@NENMJKFEHENA@@@BJ@B@FFA@JI@@FI@AD@BA@cDAD@FK@NPTDNBTBPDLHHLAL@JADC@CBCRBBB@BBDLDBHABBD@JKHILGBBDBN@HBBBBJ@@BD@@@@F@BJJAD@BBDLNNLJPH@BCN@BDBJ@@DD@B@BB@D@BDBTCFB@DBBFBJ@@EDAF@BAD@PA@DDDDBD@NGJ@H@HCHAFAB@@CA@AEAC@ANA@@@DD@RCPCAENAB@BDDAB@BDD@B@JB@FB@F@DABA@AF@"],"encodeOffsets":[[117731,37838]]}},{"type":"Feature","id":"130481","properties":{"name":"武安市","cp":[114.194581,36.696115],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@H@TBRBJAP@JANCJGHIBCNG`INCZGLEHQPI^SJINMJKBKDGDOBSFEJIDILGLILEHGLIXCN@V@N@TININMFCA@@ACAAC@E@EGECA@@BCH@JBDA@@BALEBA@AH@FBH@FD@BDBBARCRA\\@^BZDPBT@^@^AVDJDJFTNXBREPKLID@H@JBF@@BBHFNDFD@BADGDAFAL@FA@EDBBA@BF@FADCB@LFXDLAV[HKBCCa@UGIACAEACACAAEADAB@BABEDELAFCBAAM@EFI@E@ACACMCBEECEECIEC@MEIOAICCAACDKBCCACCCGACBAABE@ABCAK@KAAAEAA@A@AAA@CBABC@KAACBACBCBABIBCACEIEOCCA@@@@@IBAAGIACCEB@BALCAGACCIA@AGAACB@@AB@@A@A@A@A@@A@@A@@@@A@A@A@@@AB@A@BAA@@@@@@AC@@@@@C@@@AAA@EDQBCABODIBCJAHAFCHCF@BGGCBEBAD@BB@EEAIEE@BCDCMEACFMFE@QBCCACBG@CCBCS@E@@C@GCAAACCCD@D@FCBBF@BMB@@@DCB@FA@GBE@A@GB@@@CGBAAGGCEQCSEUGSA_FOFIFABKBGAAAG@CBABBJBLAFEDC@E@CHCDAECAEBAEIOBE@AI@O@CBADADBF@D@@@@@BEDABCBGBOAAAAACKDOAA@EBELG@ECGACEAIBECAACAG@CG@A@ECAA@A@AAA@A@C@@AA@A@@@AADA@CAAECEEBCB@CACB@AAICA@A@CACIDADA@EFK@GEA@CAAEG@CBEAABIDCFEDABABC@GCEGCGACCAC@@AACAA@@CICCMBOHGDIFOFMHEPGRCLCTCPOHO@MGEKCIAKMOEIEEGBKLAF@RBP@@DPFXDJDRBPEHMDOJAB@@@@GNBJPVLPLTHPJRLX@PALGJAJHHJJDJCNENKNMJMPKRETETIRGLOFU@QDQDUFYFOCWEMDCNDRFL@JCNEVAPCBAD@@@F@D@DABEHADCBGDIF@BDLBBBB@@NBB@HI@GF@DLIJBHBDJAFCH@DBB@JJFPCZCJINIPCHBJJH@LCBECEAEBGH@BAFEPIRDJPHNFDNFLRNHNTPPHRFNFRB"],"encodeOffsets":[[116570,37902]]}},{"type":"Feature","id":"130435","properties":{"name":"曲周县","cp":[114.957588,36.773398],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@AEA@ACEKCS@UK@@EAB@AE@AAAIKBEEAAAACEEGBAB@CMAAGCCCAAAIA@A@AKBCBEBAFCDBBA@DB@FBACD@@AQ@B@HA@AFAFC@G@@DAH@HGDAJ@HBF@BBL@FAHC@CA@@ADCH@AEE@AIG@BCBC@ASBIDSBA@AA@KEB@M@A@@BF@A@OBCBGBCFCHCNADADC@QE@ACAAI@GGGACGHA@@@@@@HB@@@@@@BD@C@@N@AI@C@E@CDEBA@A@A@C@AAGD@DA@CDEBFPEPAHGBMBIBU@WAQBIDMV@T@X@PAJEJMFODKHMLGRERMJKFIDIBOOAOCDQXEBMMIQGACCGCMGEACCIQBAE@@IBED@BCBE@AEUDKBED@FC@GAA@IFBJB@H@FA@DBJAB@BFD@@DAJ@FDBFD@BDC@BFBFKD@@CB@@@DA@@CI@E@A@AGCSCBC@AGGBAGSDA@C@@DKBK@@IEQ@@KBAB@B@B@BCAAA@B@BE@CBEB@A@AEBCECBB@GBCA@CE@EBBFC@@BA@CBC@A@@AE@A@@B@B@@@DE@@FC@AHS@@FI@A@A@C@AB@B@HIJSFQFABBHIBEFADEBEDE@@@@CEEI@E@BB@BCAAC@AEAGBBFC@Q@ACGB@BBFCB@@E@BFIBIHAGMCIBOBBBCBG@ECMBGBA@A@CF@LA@AD@FF@@H@BCBQBCBEAUB@A@EC@A@@B@FIFCBMBMAIDEDBFD@B@BFE@FLBBNHF@J@B@@RA@@AG@CH@HC@@@@@@@@DA@@DFD@@DNF@BBBB@X@@GB@F@@@FBAB@@B@BBBB@B@BAB@@@@DBBB@@BBFTAB@@DBFBBPCACBG@AD@@@@ABA@B@B@@BA@AB@@ABBB@H@D@FAB@FBJDDBBDDF@@BJBBD@@B@DC@A@A@AF@BGBAD@@HHJRFNFPHPNRJNGN@FB@D@BDFADJBFAF@@EB@@@PF@BPF@DNMFED@FBFB@DHC@ABBHBFFE@HFFJAB@LADDAD@@A@BHFA@B@FBJEAED@DBJ@@C@ABBHJ@@FCBBHHDBD@FBLAJADC@A@APF@L@DBHA@HDB@ABA@@@@@AB@@D@BDBJB@ABAJCLF\\J`@NA^G`DRBFBTHD@AABCHCB@@A"],"encodeOffsets":[[117866,37846]]}}],"UTF8Encoding":true});}));