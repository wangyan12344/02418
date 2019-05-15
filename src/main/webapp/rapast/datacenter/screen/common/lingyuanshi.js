(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('凌源', {"type":"FeatureCollection","features":[{"type":"Feature","id":"211382","properties":{"name":"凌源市","cp":[119.404789,41.243086],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@@A@@@CBABABA@@@A@@BAB@B@B@D@D@@@@AB@@D@@@@@BF@B@D@B@D@@@BBB@BAB@B@@BB@@@AA@@@ABE@A@@@E@A@ABAB@@AB@FABA@@@@@C@A@C@A@A@@@CB@@AB@@A@@AA@@AA@AB@@ABABA@@@@D@BAB@DAB@B@@@DCH@B@B@B@B@@@@AD@@AB@D@BABA@C@@@@@@BB@@@@D@@@@B@@@@B@@@@CB@@@@@@AD@@@BADAB@B@@@DBFB@@F@B@B@D@BAB@DAFAB@BA@@@ABCBE@@TBJDHBJBD@FADEFCFCFCJCHEHEDEEGEECCGGGEAE@GFGHEVENENENEGEKIMKMQIKEEKIIEMEEGCCDIDEFEHGFG@KCGEIIGKEKIGMDIBKHCFCHALBN@R@PGTKRIRKNINKHGJKNMHIBK@KEGEGCEAIAGEEGCEAGBMFGFQJQFIAIC@BA@@@C@@B@BC@@@A@AAACA@A@ABAB@BABA@AAA@A@@@A@@C@@A@AA@AB@@AA@@A@ACAA@@A@AC@@A@A@@B@D@@C@@B@BBB@B@@A@@BAB@B@B@B@B@B@@CD@B@BABA@@B@@AD@@A@@BBD@@@@@B@B@@AB@D@B@BABABAB@@ABBB@B@B@@@@AB@DBB@B@B@BAB@DAB@B@BA@@B@B@B@@AB@DBBAB@@@@@@A@A@ABC@@@A@AHEFIHCJAP@N@HAJGBGBG@C@EJGJCLELAJCHCFEDCBIAMGMGCGEIEKCOGOGOGKAK@MAO@CAA@AAAAACAB@@A@AB@@@@@B@@@@@@@B@@@@A@@B@BDB@B@@A@@@@@CA@@AABA@@A@EAA@AA@@@AA@@@@B@@A@@@@B@@A@@@C@A@CF@@C@A@ABAB@@A@AB@@A@@A@@@@@A@@@AAA@@ACAC@A@AA@@A@@@A@@BAB@@@@@B@B@@@B@B@B@@@BA@A@A@@DA@A@@@A@A@A@@@C@@@A@@AA@A@A@A@@B@@@@@@@DA@A@A@A@A@@BA@A@@BA@AB@@A@@DA@A@@@C@ABC@AB@@CB@@@BAD@BA@@BA@CB@@@D@B@D@@@@C@@D@@A@@@B@@FB@BB@FDDB@@D@@@B@@AA@@ABABABGB@@AD@BABAB@BCB@@@@AA@AAI@CAAAAAAAA@A@CB[I[_ICSBSK@@@@MG@@@@SIGSIGSAKI@@@AAA@AC@A@A@A@@A@@BABABAB@B@@@D@BAB@B@BA@@@C@ADCBAB@@@B@D@B@B@BA@@@@B@B@@AB@@A@@BAB@@@BBB@BA@@@@BBBADBB@BB@@B@@AB@@@BA@@B@B@BABB@@B@DBDB@@DBB@@@B@@@@@B@B@DAB@@@L@FCFGBCBG@CACCGCEAKCC@G@EBIDGBECGEGECECKMCKEKCK@IEGECCCCAC@CEICC@ABC@CAC@A@AA@@A@ABCD@@GBCAABA@A@ABAA@@@A@@@AECCCA@A@A@AAAC@@@@@AFAD@ACIEGIICGCGIIGGKCK@G@MCIIOGEIGKGKCIEGAG@GDG@G@IAKAICQKGCMKKKIOIMGEECIIGEKE@CA@AAAA@@AAAACA@@DAB@BBB@AAAA@@CAA@@ABA@@@A@@@A@@A@AAA@@@CB@@A@@@@A@A@@EAC@C@CAAAA@ACA@@@AA@BA@@@C@CBEBC@A@BB@B@B@BAB@BA@@@AB@BCBAB@@ABA@AB@@C@@@C@@@CA@AA@AA@@BCCA@A@A@A@@@@AAAAA@@A@A@@AA@@@@AAA@A@EEGKAFEDADEBG@C@I@KAI@K@KDKDGDG@EACCGCGEGACA@@CDABCB@@@B@D@D@DBB@D@B@B@@@B@B@B@@CBA@A@@@AB@@@BBB@@@@@DCBABEB@B@BA@@BED@B@B@@DDB@B@DBBB@B@@BB@@BBNJHHRJLRHNFJAJEHCFGFKDIBMCEACAIEKIIEICICMGMGKCIAGAE@CBGDEFGDEBIBEAGAEGCCCC@BA@CBC@C@C@@@@BBBA@BBA@A@ADAB@B@BBB@BAB@BADAF@@A@IBGD@@@BAB@@ABCBCBA@@BC@ABA@@BA@@BA@AAA@A@A@A@A@A@A@CCAAAAA@AAA@ABA@ABA@@B@BA@CB@@EFABA@A@A@@@ADCBA@CBA@AA@@AAA@A@@@AB@B@@@B@B@@@B@@A@@@@@AB@@A@@BABABAB@@CBA@@@ABA@ABAB@@ABA@A@AB@BA@ABA@@@AB@B@@GDAB@@A@@B@DAB@D@BBB@@@@C@@B@@@B@D@@@B@@AFAB@@@BAB@B@@AB@BBBA@@BABA@@BA@ABAB@@A@C@@@ABCB@@A@@@CBCA@BA@A@E@GBC@AA@@@@A@C@CBABABCBA@CBA@EBA@A@A@A@A@A@@AE@C@AAA@A@CA@@@@AB@@@D@BDD@@B@B@B@BBB@BB@B@@@D@@@B@@@B@@BBB@@@BBBBBB@@@B@@@B@@@B@B@D@@B@D@@@@B@@EBAB@@@BE@ABCBAA@AA@A@EAAAA@A@CBCFABA@@@CB@A@@@A@A@@C@CBA@@BAB@@@B@@@BAF@@ADA@A@A@CD@@A@A@A@@BAB@@@@A@A@@@CHA@@B@@@BAB@B@BC@AAC@AAA@A@A@A@@@AAA@@@A@@B@B@DAB@BA@@B@BAB@B@B@DAB@B@BBD@B@@@B@B@B@B@@B@DBB@BBBD@@@B@D@D@B@@B@BB@@BDBD@@@BAB@@@BBB@@D@B@B@@BFDFB@@BBBBD@B@BBB@B@@B@B@@@BABA@@@@BBBB@@B@@@B@BBBDDBBDBB@@@@BBF@@BB@@@@@B@B@@DD@BBB@D@@@BBB@@AB@B@@@BABB@@BDB@@BB@F@BB@BD@@@BAB@B@B@BA@BB@DBB@B@DA@BBBB@@BB@@@@A@A@@BAB@B@BB@@D@@@@AB@B@F@@ABAD@BAF@B@BA@@B@@B@@BD@D@HABB@@BBA@AD@B@B@B@@BB@FBBBDBBBB@D@@BB@DA@AB@B@@B@B@B@@@@@@B@@CD@@@F@BBDBB@B@@BB@@@D@BB@B@FBPFBB@@@B@BD@AB@@@B@@@@BA@@BCB@DADAD@FCB@@@BD@@D@DAHABA@@AE@@B@B@DAD@B@D@BAB@D@H@FBB@@BB@B@@@@AB@D@@@BB@BDAD@B@FB@@@ABC@@D@DB@BAB@@A@@@B@BAB@@@@@@DA@DBB@@@@AB@@@AB@BNFJBD@B@@@B@@@H@@@B@BD@FDJBFBHDDFDJHDDFH@DADEHEDOFKBSBQBSBUDQD@B@@ABEDCD@B@@ABA@@@CBAB@B@BAD@@@B@BABABCD@@@BBBDH@B@@@B@DAB@B@BAD@@@@@BB@D@@@@BB@DDBBB@BBBB@BBD@BB@@B@BB@B@BB@BDBFDD@@B@BBB@@BB@@DDBD@@BB@B@@B@DAB@BA@AB@B@B@D@BADBB@FBD@@@B@B@B@@@B@BA@ABAB@D@BAFAB@BADAB@BAD@FBBCB@BAB@B@@BB@@@BAD@F@D@FBD@B@BBB@BBB@@A@@@AAAAAA@@AB@@@B@@A@AD@FBHDFHDJHHJBDCFAH@HDJDFBDDFDDFBFBH@PAL@RBTBFFDHFNBNBN@L@JANBLJHDFFJJJNFHNLLFLBJFHDFDDFFJDL@HGLGHKFKDEBCD@FBDDBDDH@HATBVANBFBDDBFDBCD@B@D@@@D@B@DAH@@@B@@D@H@B@ABBB@@@BB@@@@@A@BF@@@@@@BB@DBDBAAB@BD@H@B@B@B@DAB@BBBB@@@@@BBBFFCB@B@@B@DDDBBA@@@@BBBB@@@B@BB@BBBBDF@BBB@DBBABBBABBB@DAB@@@D@@CD@DCFGHAJALBJ@DBDBDFFDBLBLALAL@J@NBNBNBHDDDDJBHBLDDFDF@DA@EBG@ECGDEDCFCDBHBBFDHDJCJCJGLCHEH@DAFDDFBFDDDDJBHEDIFKDOHEFAHBBHDN@L@PDHBPBNBJFJFLJDADAD@DBB@B@BBBBBB@B"],"encodeOffsets":[[122243,42419]]}}],"UTF8Encoding":true});}));