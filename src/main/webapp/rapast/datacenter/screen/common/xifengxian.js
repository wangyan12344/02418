(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('西丰县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"211223","properties":{"name":"西丰县","cp":[124.72332,42.738091],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@@@B@@@@@@BBB@@B@BBB@BBB@@BB@@BA@@B@@BB@@@@@B@@@@ABA@@BA@@B@B@@@@@B@@@@AB@@AB@@@@@B@@@B@@A@@@@B@@@@@@@B@@BB@@@@@@@BA@@BA@@B@@@@@@@B@@B@B@@@@B@@B@@B@@B@@B@@B@@@@B@@@@@B@@B@@BB@@@@@@B@@B@@@@@BB@@@@@@B@@@B@B@@BB@@@B@@B@@@@@B@B@@B@@@BB@@@@B@@@B@@@B@B@B@@BB@B@BBB@@@B@@BB@@@@@@@BB@@@@@@B@@@@@@@BA@@@@B@@@@@@A@@B@@A@A@@AA@@@@@@@@@@B@B@B@@@B@BB@@@BB@@@@@@B@@@@AB@@AB@@@@BB@@@@BBB@BBB@@BBBB@@BB@B@@B@@BB@@B@@@B@B@@@@@@BBB@@@@@@B@@@@@@@BAB@BA@@BB@@B@@A@@B@@AB@B@B@B@B@@@B@@BB@B@B@B@@@B@B@@@@@BABA@ABA@@B@B@BA@BB@@@@@@B@@@B@@@BB@@@@B@@@@AB@@@BA@@@BB@@@BB@@BBB@@BB@@@@@B@@@B@@@B@BA@@B@@@BB@@BBBB@@@BB@@B@B@B@@@BBB@@BB@B@BBB@B@@@B@B@@@BAB@B@B@B@B@@@@@BB@@@B@B@@@BB@@@B@@BB@@@@BB@@@B@@@B@BB@@BB@@@@@B@@@B@@@B@@@@BB@@B@B@@@B@BAB@@@B@@@@@@DBB@@@@BB@@B@B@B@BBB@@@B@@B@@@B@B@@BB@@@@BBB@@@B@@B@BB@@BB@@@@@BA@@@BB@@BBB@BBB@@@@BBB@BB@@BBBBB@@B@@BB@@BB@B@BBB@@@@@B@B@@ABA@@B@@A@@BB@@BB@@B@@BB@@@BB@B@@B@@BB@@@BB@B@BBB@B@D@BBB@B@@@B@DBB@@@B@@B@@@@AB@B@@@B@@@B@@BB@B@@@B@@@@B@B@B@BBB@@@B@@AB@B@@BB@B@@@@BB@@B@@B@@BB@@BB@B@BB@@@@BB@@@B@@@@A@A@A@@@CB@BA@@@@B@@@B@BB@@B@B@B@B@B@@AB@B@B@@BB@@@@@B@@@@BB@B@@B@@BB@B@DBB@BBB@B@DBB@B@B@@@B@FAB@BAB@@A@@BAB@B@@@B@@@BB@@@BBB@@@B@B@@@B@@@B@@BB@@@BA@AB@@@@@B@@BBBBD@B@@BB@B@BB@@@@@B@@@@@@@@AB@@B@B@@@B@B@@@@B@@AB@@@B@BBDBB@@BB@@B@@BBB@@@@BB@@@@@@@BB@@B@@@B@D@B@B@B@@@BBB@D@B@@@BAB@@AB@B@B@B@D@B@BAB@B@@AB@@@B@@@B@@BB@B@B@@BB@B@@B@@@BB@@B@@@@@@B@@@BAB@BBB@@@BBB@@@BBBBB@BB@@B@@DD@BBB@BBBB@BBBB@BBBB@BBBBB@DB@@B@B@BBB@BBB@@B@@@BB@DDB@BBB@BBB@@@DBBBB@@@DBBBB@@@@@B@B@B@B@B@B@B@B@B@B@D@B@@@B@B@DAB@B@B@BAB@B@B@@@HBFBB@@@@@BB@@BBBBDB@@@@@@B@@@@B@@@B@BBB@B@@@D@@@B@@@BB@@@@B@@@@@BB@@B@@@B@@B@BB@@BBB@@BB@BBBBB@BBBBB@BBBBB@DBB@BBB@BB@@BBB@@BB@@BBBB@BB@BB@@BBB@@@B@@@B@BAB@B@B@B@BBB@B@@@B@@BB@@B@BBB@@@B@BBB@@@B@@@B@@@B@@@@@B@@BBBB@@BB@@@@@B@@@B@B@@@BA@ABABAB@BA@@B@@@B@B@@@B@B@@@B@B@BBB@B@BBB@B@@BB@@@BB@B@@@B@@BBB@@@D@@@B@B@BAB@@@B@D@BBB@BBB@BBB@B@@@B@B@BB@AB@BA@@D@BA@@B@BAB@@@B@BAB@BA@AB@BAB@@@B@@@D@BBB@B@B@B@@BB@BBB@@@BBB@BBDBB@BBBBDD@@@BB@@BB@BBBBBBB@@@B@B@B@B@@@B@B@BAB@@@BABA@@B@B@BA@@@A@A@@@@AAA@@A@C@@BA@@@@@AAC@AB@@AA@@AA@AAA@EA@@AAAAA@AA@AA@A@@AAA@@@AB@BA@@BA@@@A@AAA@AAAA@AAA@@A@@BA@ABA@AB@BA@@@ABA@A@E@CBA@E@A@@@AAA@@BA@AD@DA@@@A@@@A@ACA@@IECAECCAAAAA@A@AAC@AAAACAA@AAACAIAEA@@A@@A@ABA@A@A@A@A@AAAAA@A@@B@@AB@B@DAB@BA@CBAA@AAA@EBA@EBC@C@C@A@C@C@CC@@AAAABAAA@A@A@AB@BA@@B@B@B@BABC@@@ABA@AB@@A@ABA@AB@BA@@B@BAB@B@BABCBA@A@A@C@AB@@AB@@AB@@A@@A@A@A@AA@@A@BA@@@A@A@@BA@@B@BAB@@@@A@@@A@@AA@A@@@A@AB@@@B@@@B@B@@@BAB@B@@@BABA@@@ABA@@B@@@@@BA@@@@@@AA@@A@@@A@@@@@A@@@@@AA@@@@@@@@@A@@@@@@@@@@@AB@@@B@@@@@@A@@@@AA@@@@A@@A@@@@BAA@@A@@@@@@@@@@@A@@B@@A@@@@@A@@@@@@@@BA@@B@@@B@@@BA@@@@@@@AB@BA@@@@BA@@A@@@@AA@@B@@A@@@A@@A@@@@A@@A@@@@@@@AB@@@@@@A@@@@@@A@@A@@A@@@AB@@A@@@@A@@@@A@@@@@@A@@@@@AB@@@@@@@@@BB@@B@@@@@B@@@B@@@B@@@@@@A@@@@@A@@@@A@@@@@A@@@A@@A@@AAA@@@@@@@@@@@@@BA@B@@@@B@@@B@@@B@@@B@@@@A@@@@B@@@@@BA@@@@@@@A@@@@@@A@A@@@A@@@A@@@AA@@@@@@@@@A@@@@@@@@@A@@A@@@A@@@@AA@@@@A@@@@@@B@@@@@@AB@@@AA@@@AA@@@@@A@@@@@@AA@@@BA@@@@@A@@B@@@@@@A@@@@@@@A@@@@@@@A@@@AA@@A@@A@@A@@@@@@@AB@@@B@@@B@BA@@B@@@@@@@@A@@@@@@A@@AA@@@@@@@@A@@@@B@@@@@@AB@@@@@@A@@A@@A@@@@@A@@@@@A@@@A@@@@AA@@A@@@@@A@@@A@@@@@@@@A@@@@@@B@@A@@@@@@@@@@AA@@@@@A@@@@@@@AB@@@B@@AB@@@@@@@AA@@@@@@@A@@@@@@@A@@@@@@@@@@A@@@@@@@A@@@@@@@A@AA@@@@A@@@@@@A@@AA@@@AA@@@@@@A@@B@@@@A@@B@@@@@@A@@@@AA@@@@@@A@@A@@@@@@@@@AB@@@@A@@@A@@@@@A@@AA@@@@@AA@@@@@A@@@@@A@@@@BA@@A@@A@@@@@@@@A@@@@@@@A@@@@@@@A@@A@@@@@@@A@@@@@@A@@A@@@@A@@@AB@@A@A@@AA@@AA@@@@@@@A@@@A@@@@@@@@@@@@B@@@B@@@@@@@B@@@@@BA@@@@@@AA@@@@@A@@@@@@B@@AB@@@@@@A@@@@BA@@@@A@@@@A@@AA@@A@@@@@AAC@@@AA@@A@@@@@@A@@@@BA@A@@@@@A@@@@@@@AA@@A@@@@@@BA@@@@B@@@@@B@@A@@B@@@@@@@BA@@@@@@@AA@@@@@@@@@A@@@@@A@@@@@@@@@@A@@@@BA@@@@B@@@B@@@@@@A@@@@@@@AB@@@@@@AB@@@@AB@@@@@A@@A@@@@@@@@@A@@@@@@BA@@@A@@@@@@@AA@@@@@AA@@@AA@@@B@@A@@B@@A@@@@@A@@@A@@@AA@@@@@@A@A@@@A@@@@@@@@@A@@B@@AB@@A@@@@@@@AA@@A@@@A@@B@@A@@@@@@B@B@@@B@@@BAB@@@@A@@@@AA@@A@@AA@@A@@@@@@@@@A@@@@@A@@@@@@@@@A@@BA@@@A@@@@@@AA@@@@@A@@@@@@@@BA@@@@@@@AA@@@A@@@@@AA@@@@@AB@@@@@@A@@@@@@AA@@@AB@@A@@@@@@@A@@A@@@@A@@@@@@B@B@@@@A@@@@@A@@@@@A@@@@@@@@@A@@B@@@@AB@@A@@@A@@@A@@@@@@B@@@B@@A@@@@@@@A@@@@@A@@@@@A@@@A@@B@@A@@@@BA@@BA@@B@@@BA@@@@@@@A@@@A@@@A@@@@@A@@@A@@@@@A@@B@@A@@@@@A@@@A@@@A@@B@@@@AB@@@@@@@B@@@@@@A@@@@@A@@@@@A@@@@@A@@B@@A@@@@@AB@@@@@BA@@B@@@@@B@@@B@@@B@@@BA@@@@@@B@@@@@@@B@@@BB@@B@BB@@B@@@B@B@B@@@B@@@@@B@@AB@@@B@B@BA@@B@B@B@BA@@B@BB@@B@BB@@@@BB@@B@@B@@@@BBB@@BB@@BBB@@@@@B@@@@@@BB@@@@@B@@@@@BB@@@@B@@@B@@@@@@BB@@@@@@@BB@@@@@B@B@@@BB@@@@B@@@@@@B@@@@@@@B@@@@AB@@@@@B@B@@@@BB@@@B@@@@@BA@BBA@@B@@@@@@A@@B@@@@A@@@A@@@@BA@@@@@B@@@@@B@@@@@B@@B@@@@B@@@@@BB@@@@B@@@@@B@B@B@@@@AB@@@@@B@@@B@@@B@@AB@@BB@BBBDB@B@B@BA@@BA@@BABABA@AB@B@BA@@@A@@B@D@@@BAB@@@B@@@@@B@@@@@@AB@@@@@B@@A@@@@B@@A@@@@@A@@@@@@BA@@@@@@B@@@@@B@@BB@@@B@@@@@B@B@@@B@@@@@B@@@@@@@BA@@@@@@B@@@@@B@@@@@B@@@B@@@@@BA@@@@B@@@@@B@@@B@@@B@@@B@@@B@@@B@@@B@@@@@B@@@B@@@@AB@@@B@@A@@@@B@@A@@@@@@@@@A@@@@@A@@@@@@@A@@B@@A@@@@@@@AB@@@@@@A@@@@@@@A@@A@@@@@@A@@@@@@@A@@@@@@B@@A@@@@@@@@@A@@@@@A@@@@A@@A@@A@@A@@@@@@@A@@@@@@BA@@@@B@@@@A@@@@@@BA@@@@@@@A@@B@@@@@@@@AB@@@@A@@@@@@@@B@@@BA@@@@B@@@@@B@@BBA@@B@@@@@B@@@B@@@@@@AB@@@@@BA@@@@@@@A@@B@@A@@@@@A@@@@@@@AB@@@@@@A@@@@B@@A@@@@@@@A@@@@@A@@@@B@AA@@@@B@@@@A@@@@@@@@@AA@@A@@@@@@@@@@@A@@@@@@@A@@A@@A@@A@@@@A@@@@A@@@@A@@@@@AA@@AA@@A@@@@A@@@A@@@@@A@@B@@@@@@@@@@@@A@@@@@@@A@@B@@@AA@@@@@@@@@@A@@A@@@@@@AB@@@@@@A@@@@@@BA@@@@@@@@@A@@@@A@@@A@@@@@A@@@@@@A@@@@@@@@@A@@@@@@@@@A@@@@@@B@@@B@@@B@@@@@@BB@@@@@B@@@BA@@B@B@@@@AB@@@@@@@@A@@B@@@@@@@@AB@@@@@@@BA@@B@@@@@@@@AB@@@@@@AB@@@@@B@@AB@@@@@@@@@@@@AA@@@@@AA@@@@@@@@@AA@@@@@@@@@@A@@B@@@@@@@@A@@@@@@@@@A@@@@@@@@@A@@@@@@@@@@AA@@@@A@@@@@A@@@@@A@@@@A@@@@@@@@@@@A@@@@@@@@@A@@@@@@A@@@@A@@@@A@@@@@@@@A@@A@@@@@@@@A@@B@@@@@@@@A@@B@@@@@@A@@@@@@@A@@@@@@@A@@@@@@A@@@@AA@@@@@A@@@A@@@@@@@AB@@@@@@@@@@A@@BA@@@A@A@@@A@@@@@A@@@@@@@A@@A@@@@@@@@AA@@@@@@A@@A@@A@@@@@@AA@@@@@@AA@@@@@A@@@@@A@@A@@@@A@@@@@@@A@@@@@A@@@@A@@@@@@@@@@@AB@@@@@@@B@@@@A@@B@@@B@B@BA@@B@@@@@@AB@@@@@BA@@@@@A@@@@@@@@A@@@A@@@A@@A@@A@@@A@@@@A@@@@@@@A@@@@@@@@BA@@@@B@@@BAB@@@BA@@B@@@@@BA@@@@@A@@@A@@@@@@@A@@@@@@@@BA@@@@@@@@BA@@@@@@@@@AB@@@@@B@@A@@B@@@B@@@@AB@@@@@B@@@@A@@@@@@@AB@@@@A@@@@BA@@@@@A@@@@BA@@@@AA@@@@@@@A@@@@@@@@@A@@@@@@@AA@@@@A@@@@@A@@@@A@@A@@@@@@@@AA@@@@@A@@@@@@@@@@A@@@AA@@A@A@@@A@@@@@A@@AA@@@A@@@AA@@@@A@@@@@A@@@@@@@A@@AB@@@@@@@@@@A@@@@@@@@@@@AA@@@A@@@AA@@@@A@@@A@@@@@A@@@A@@@@@A@@@@@AA@@@@@@A@@A@@@@@@@@@A@@@@@@@AB@@@BA@@@@@@BA@@@@@@@A@@B@@@@@B@@@B@@@B@@@@@B@@@B@@@@@@@B@@@@@B@@@@@@@B@@@@@B@@@@@B@@@BB@@B@@@@@B@@@@@@@BBB@@@@@B@@@@BA@@@@@@@@@BB@@@@@@B@B@@@@@B@@@B@@@B@@@B@@@B@@@B@@@BAB@@@@@B@@AB@@@@A@@@@@A@@@@@@@A@@@@@@@@@A@@@@@A@@@@@@@@@@@AB@@@B@@@@@B@@@@@@@B@@@B@@@B@@@B@@@@@B@@@@@BA@@@@B@@@@@@@D@@AB@B@FAB@BA@A@A@@AA@@A@@@@C@@@ABABA@AB@@AFA@@BA@@AACECEAA@@@@@@FC@A@A@@AC@@CAAA@AAA@@@A@@AA@A@@AA@@B@BAB@DC@A@AB@@A@BD@BB@@D@@ABAB@DC@@B@@A@@B@@@B@@@B@@A@@@C@A@A@A@@BADAB@B@D@@@D@@@B@@@B@@BB@DBB@BB@@@@@BB@@B@@B@B@HBDBBBBBBAD@B@@@BA@@BABAB@B@DB@@@@BBBB@@D@@@B@@@BB@B@@H@B@B@B@@@DBB@BAB@F@B@B@DABAFAF@@@@A@@@A@@@ABABE@A@@@A@@BAA@@@A@@@@A@@AAA@AA@@AAGA@@@@AA@@BAB@BABABABAB@@A@@AAAACCA@GEC@AACC@AAC@@@@FADA@@@AB@@@@@@A@@@@@@@@@AB@@@@A@@@A@@@@@A@@@A@@@A@@@A@@@A@@@@@A@@B@@@@A@@B@@A@@@@BA@@@@@A@@@@@@@@AA@@@@A@@A@@@@@A@@@@@A@@@@@@@@@@@@A@@AA@@@@@A@@@A@@@@A@@@@@@@@AA@@A@@@@AA@@@@@A@@@@A@@@@@@@A@@@A@@@@@@AA@@@@A@@@@@A@@@A@@@@@AA@@@@@A@@@@@@@A@@B@@A@@@@@A@@@A@@AA@@@A@@@@@A@@@A@@AA@@@A@@@A@@@A@A@@B@@A@@@@@A@@BA@A@@@A@@AA@@@AA@@@A@@@@@@@A@@@A@@@A@@@A@@@A@@AA@AA@@A@@A@@@@@A@@@@BA@@B@@@@AB@@@@AB@@@@AB@@@BA@@B@@AB@@@B@BA@@B@B@@A@@B@@@B@@A@@@@@@B@@A@@@@BA@@@A@@B@@A@@@@@AB@B@@@B@@AB@@@@@@@@AB@@@B@@A@@@A@@BA@@@AB@@@@A@@@@@AA@@@@A@@A@@@A@@@@@A@@@AB@@@@@@A@@@A@A@@@A@@@A@@@A@@@@AA@@AA@AA@@@@@A@@@A@@@@@@@A@@B@@A@@A@@@@A@@@@A@@@@@AAA@A@@@A@@AA@A@@@A@A@A@AA@@@@@@B@@@BA@@@@@@@A@A@@@@B@B@B@BB@@B@B@H@@@B@B@@@@@D@B@@@B@@@B@B@@@BAB@@AB@@ABA@@BAB@B@@AB@@@BAB@B@@@@@@AB@@@B@@AD@B@B@B@@@BA@@@@@@@@@C@@@A@ABA@@B@@@B@@AB@@@@@BA@@AA@A@@@A@@@@AA@@@@@@@A@@@@A@@@AA@@@@A@A@A@AA@@A@A@@BA@C@@@@@AA@A@@A@A@@AAAA@A@@@AAAA@@@@CAKGEC@A@ABA@@@A@A@A@CCAA@AA@CCAA@CAE@AA@@A@A@C@@AA@@ACA@A@@CA@@GAKCAA@@AB@@A@A@A@@@@AAA@A@@CA@A@@ABA@C@@AACA@@A@@BC@@@A@A@@BAAA@@BA@@@@AA@@@AB@@@AA@@BAA@@ABA@@@C@@@@BAB@@@BC@A@@B@@@BC@A@@@A@AA@AA@A@@@A@@@AA@AAAA@@C@A@A@A@C@A@@AC@CCAAC@@@ABA@A@A@ABC@@@AA@@A@@@C@@@AAA@A@AAA@AB@@A@AAAAAAA@@AA@@A@A@A@@AA@@AA@AB@BAAA@@BA@@@A@@B@@A@@B@@A@@BA@A@ABA@A@@BCBAB@A@@A@A@A@@A@AA@@ABC@@BA@EAAA@@A@CACA@@@B@@@@B@@B@@@B@B@B@@@@EBGB@@@AACA@AAE@@@CC@@@@@AA@@@@A@@@AAA@A@@AAABA@@BA@A@A@ABAA@@A@@@A@ABAAA@CBC@@BA@A@@@@B@BA@BBAB@@BBB@BB@F@@B@@BBD@@B@@B@@CDABA@@B@@C@@B@@E@@@@@AB@B@@AB@B@@AD@@ABBBA@A@AB@@ABAB@BC@ABA@@@A@A@@@A@ABAACBA@A@A@@@AA@AA@A@@AC@@CA@@A@@A@A@@@A@A@A@A@A@C@A@@@@B@@@@A@EA@@A@@@C@AB@@@B@@A@AAA@A@AB@@AAC@@@CB@@CAA@CBABABA@A@@BB@ADB@@B@@@BCD@@@@AB@@@@A@@@@B@@@BCAABE@C@KAC@E@AAEA@@IFGBCBE@G@CBC@SDABG@IDA@@@BB@@CDCBABC@AB@BG@A@ABA@A@@@CA@@E@ABEBC@BB@@ABBB@@BB@BDBB@@BFBB@@@@B@@DBHD@@@BA@AD@@AB@@@B@@BB@@@BBB@@@BBBA@@@BB@@@BAB@@@BAD@@CB@@AB@@@B@@ABABE@ABA@A@@@AB@@C@ABC@A@AF@B@@@B@@@D@@ABABAB@B@DA@EBA@ABCB@BA@AB@@@B@B@@@B@@@BDD@BA@@B@@ABABA@EB@BA@@B@@@B@@AF@@ABAD@@ABA@A@ABAACBC@EBA@A@AB@@ABCB@@CD@BCB@@@@@B@B@BABA@ABABA@C@A@CDC@A@A@@@CAA@C@AAA@C@CAGC@A@A@AC@A@AA@@@A@A@C@@BA@@AAB@@AA@@A@A@A@A@@AAAAA@C@CA@@@AA@CAAAA@@@EBA@BBA@@@A@A@A@@B@B@@AB@@A@@BAB@@A@@@A@@BCB@BAB@@AD@@C@AB@@A@A@AB@@A@@BCAA@@BABA@ABA@A@C@A@@@A@@DA@@BA@@@A@@@A@AB@@A@A@@@ABA@@@A@AAA@@@@@GD@BCD@B@@@@@B@BABA@CB@@A@C@A@AA@@@@E@A@@@A@@@AB@@A@C@@B@D@@AB@@CDA@@@E@A@A@A@A@E@@@A@@A@@BA@@@@@AAA@@AAC@@AA@@@A@A@GAAAAAC@A@@@AA@@@@@A@A@A@A@@A@AAA@@AA@@@ACA@@@AAA@@AAAAAAA@AA@CAAA@@A@@@A@A@C@@@AAA@CBEAA@ACA@A@AA@@@B@@@B@@A@ABA@C@@@C@@BA@@B@@@BA@@@ABBB@@BDB@@B@@@@AB@@@B@@@BABABA@ABCD@@@@A@@@ABA@@B@@@@BBAB@B@@@B@@@@CB@@A@ABABABA@@@@@A@A@A@@@@B@@@@@BAB@@AB@BA@A@@@AB@@@B@@BB@@B@@@@@B@@@@B@@@BAB@@A@@B@@A@@@A@A@A@A@ABC@@@@BA@AB@@ABC@@@AAA@CD@BA@@BABA@@@A@@BE@CBA@C@AACBA@@@AA@@@@AB@@C@A@A@@B@@A@@@A@A@A@@@@BA@@@A@@@@@AB@@CA@BAAGBA@ACAA@@@A@@AA@@C@CA@@E@A@A@ABEBEBA@EDA@EDEDEB@BCBCBABA@@@AB@@@BA@@BA@@@AB@BEDCDA@CB@BE@AB@BCBAB@BCB@@CBE@E@GAGAC@EACAGAC@AAG@AAC@A@A@E@C@A@A@@@A@A@A@A@A@C@C@A@A@@AIBGBCB@B@@ABAFAB@BADA@C@@@@AA@A@CB@@CAAB@BA@@B@@@BCBA@A@ABA@A@@@@@CBA@ABA@@BA@@@B@@B@@@@BDB@@B@@@@@@@@D@@@BD@@B@B@@@B@@@@DB@A@AB@@A@@BAB@BABABAH@B@B@@AB@@@BA@@B@@AB@@@BA@B@A@CBA@A@ABC@C@ABA@ABC@ABAB@BAF@@ABAB@BAB@B@BABAB@B@@@@ABCFCDADGH@DABCDA@CDCB@@ADIJCDCD@@EFA@CB@BAB@BB@F@@@B@B@@B@@@BD@@@@B@@D@BB@BB@B@B@DBB@D@B@@B@@@@@BCD@@A@@@C@A@ABA@ABA@A@AA@@A@CB@@@@B@@BA@@@BBBBBBBD@@DB@@DB@@BBDDB@@@ABB@@BB@B@@BBBB@@@@@@B@@DF@BBB@@FHDBB@DD@BB@HDDBJFDBD@B@@@@B@@BDBD@D@DBF@JBD@@AD@@DD@@BBBBB@@B@BB@@@B@BAH@F@@ADAB@@@BAB@@AD@B@@@BAB@BA@@D@F@DAD@DBD@B@@@D@@@@@BBD@@BBAD@B@D@BB@@BADA@BBBB@@@B@DBDBF@DBB@B@D@BBB@BBB@B@BBD@B@BB@@BAB@BALFVLAP@HDLDJHLJLFDLHLHTLLR@DAJCF@@A@@@@@A@@B@@A@@@@B@@@@@@AB@@"],"encodeOffsets":[[127453,43851]]}}],"UTF8Encoding":true});}));