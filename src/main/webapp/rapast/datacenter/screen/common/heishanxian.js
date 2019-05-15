(function (root, factory) {if (typeof define === 'function' && define.amd) {define(['exports', 'echarts'], factory);} else if (typeof exports === 'object' && typeof exports.nodeName !== 'string') {factory(exports, require('echarts'));} else {factory({}, root.echarts);}}(this, function (exports, echarts) {var log = function (msg) {if (typeof console !== 'undefined') {console && console.error && console.error(msg);}};if (!echarts) {log('ECharts is not Loaded');return;}if (!echarts.registerMap) {log('ECharts Map is not loaded');return;}echarts.registerMap('黑山县', {"type":"FeatureCollection","features":[{"type":"Feature","id":"210726","properties":{"name":"黑山县","cp":[122.117915,41.691804],"childNum":1},"geometry":{"type":"Polygon","coordinates":["@@GEOIMEEEGECICI@@@A@A@@B@@@@@@@@CAA@@JGGGFQ@@@@@EOIUEMSAUDQQKGCA@CAC@@@EFEFSB@I@@@E@ACMBGHAF@HC@@AA@@@@@@@A@@@@@A@@@@@@@@AA@@@@A@@@@@AA@@@@@@AA@@@@@@A@@@@@@@A@@@@@@@@@@@A@@A@@@@A@@@@@@@B@@@@A@@@@@@@A@@@@@A@@@@@A@@@@@@@A@@B@@@@A@@@@A@@@@@@AA@@@@@@A@@@@@A@@@@A@@A@@@@@@@@@AA@@@@@@A@@@AA@@@@@@A@@@A@@@@@@@@@@B@@@@A@@@@@@@@@A@@@@@@@@@A@@@@@@@@@@@@A@@@@@@@A@@@@@@@A@@@@@@@@@@@@@@@AA@@@@@@A@@@@@@@@AA@@@@AA@@@A@A@CB@@A@CD@@A@@@AA@A@@BA@@@@@A@@AACE@A@A@@B@B@@@@@@A@@AAA@@@A@@@@@@AB@@@AA@@AAC@@@A@A@@@@@@AA@AA@@BA@@AA@@AC@ACC@@AC@@@AB@BABA@@AC@@@A@@A@@@@@@AA@@@A@A@@@@A@@BC@@BABA@A@@B@BABBBA@@B@@@@AA@A@AA@@@AB@@@B@@A@@@@@@AAA@A@AAAA@@AA@A@A@@A@A@C@@@A@@@@BAB@@@@AA@@AAA@@@@A@@DAB@BAB@@AAA@@A@@ABA@@@A@@B@B@@@@A@@BA@@@@B@BAB@BA@@@@BA@AA@@AA@@@BAGC[McO]@yAgAQAMASEOAMGUKSKCA@@@@WGMCUIQ@KDiQAA@@@@_M[MCA_MCCEECCEGCCAAAA@@EIEE@@CCA@A@ED@@PTEBFH@BDFHJFHBH@B@BBFKDIDGBOJSL@@@@ABMDOHULSLSFMH@@@@GD@@@@@@IH@@A@ABEB@@@@MFCB@@@@OLSLSF@AABWQ@@A@A@@B@@@@@B@@E@@@@A@A@@AE@A@@MD@@@@@@@DBB@@@BCBA@@B@B@@@BA@@@@@CB@@@@BB@@AD@BBB@@@@@B@B@@A@AA@@@@A@@A@@CI@@@@@@AB@@@AA@@@C@@@@@@BBB@@@BC@@FEDA@CBA@AB@@@@@BCB@@ABB@BJB@@BB@@B@@BB@@DABDB@@@B@@@@B@DDLPJHHBJBHGN@@@@CXAF@@@@@FAB@@@@ANALCDKP@@AB@BA@@@@@ADGHMJKDMCK@SFOFGHDLFFLFLHAFMJ@B@@@@KLGHGJENCNAB@@C@E@C@A@@BA@ABAB@B@D@BA@@BA@A@G@@@C@@BA@@BAB@B@B@B@B@@ABCBABABCBABA@K@CBABC@CBABCFCB@@@@@@@@@@@@CDAD@@EHEHEFAB@@@@CDCDADCFCFCB@A@@AC@@GAABA@A@ED@@A@A@A@@@@C@@A@CAA@A@A@A@@@A@A@@@A@A@@@AA@ACB@AA@C@ABA@AAA@AB@@A@CBAAA@A@GAQAKBNRHHHFLJNLSAI@MDMFEHDPJHJHFFFLXB\\AJAFBD@L@D@F@DDFBDBBBD@BBFFFDBB@@B@FBMFCBA@B@@BBB@@B@@@@@B@B@@@D@B@B@B@BAD@@@B@AB@@@@B@B@@@@@D@@ABB@AB@DA@@@@DB@BB@@BC@GB@@@B@D@@@@@@B@B@DAB@@@@DABB@B@@@B@BDBDBABA@@@BBDB@@@B@@@@ABAB@B@BABB@B@D@@B@@A@@D@@@B@HDFBH@B@D@@@B@@BCBA@@@@@BBB@@B@@@@A@@@FF@@@D@DGDE@@@@BBDBDB@@BB@@@BA@A@A@@B@B@AA@@B@@@@C@@@AB@@@BD@B@BH@@B@@@@B@@@B@@ADA@A@@@BB@@B@BB@@@@@BB@A@B@@BA@@@BBB@@B@B@@B@@AB@B@@@BB@BAB@B@@@@B@@AB@@@B@@B@@@B@@@@A@A@@D@B@NLBBBBBBDD@@@@C@CA@@@@@B@@DB@@BB@@CFEF@@A@DBBD@@BA@@@@@BABBBBDBB@BDBBBB@FBBAB@BAB@B@@ABA@@F@BA@@@@BAB@B@@@F@@@@@@B@DB@D@D@F@HDB@F@@BB@BBJFB@A@CF@@DHDBAB@B@B@@BBBBDB@@BB@@@@B@B@@@@@B@@BJHDD@BB@BBDDB@@B@@BB@D@BBDAB@B@@@@B@BBBB@@BABC@CBA@BB@DBBB@@D@D@B@@B@@B@@@BAB@BA@@DBFDBB@@B@DD@@@@@@@BDBD@@B@B@@ABBB@@BB@BF@@@@B@B@@A@A@@@@B@B@BA@@BFBDB@@B@BBBB@@B@@BB@DA@@FD@@BB@@CBBB@@B@BB@@@@@@DFB@B@@@DDB@@@@@BA@@@@B@DA@B@@B@@@@@@ABC@ABB@@B@AB@B@@BA@@B@B@FB@D@BB@DFDB@@DD@D@@ABAD@B@DBBBBBBD@BBDAD@HC@BB@F@B@@B@@EBKJBD@@B@@BDB@DBBB@@BB@HA@@@AB@DAB@@@F@@@@@FADAB@@BB@@@B@@@@@FA@@@@BA@B@@@@A@BB@@B@BA@@B@@@FBB@@A@@B@FBABADH@DBD@@B@@F@@@BBB@DA@@DA@@@B@@B@@BB@@B@BD@DB@@B@@@AB@@@@@BBD@B@DB@B@ACB@B@@@@@HABB@@A@AB@@@@@@@BCBA@BDBB@DD@DAH@ACD@B@@B@@D@@B@@F@@A@AB@FBLHA@@B@D@@B@B@@A@@FBB@@ABBDBBBTHBB\\LD@VLVLP@XHVJZLTLRDXLXHXFPFXHPFHFB@@@HDBCDC@@HAF@B@B@DBB@BAB@F@B@BA@@BABA@@AA@@A@A@C@@BAAA@@AA@@B@@@B@@A@@@CAAA@@BA@@AAB@@ABABAD@B@F@@@B@@A@A@A@A@AA@A@@@A@AAA@ACA@AAC@A@AA@@AA@AAC@ACACCCG@@@A@@D@B@D@BBD@DBB@B@BBB@B@B@BAB@BABABA@@BAB@@@@A@AAAA@CAE@GAC@AAA@@C@E@EBABADAF@PAD@B@@AAAACCCCCAC@ABAHADA@A@A@AB@D@D@@@BAAC@ABA@@AG@CBC@@DABAJ@D@B@B@B@@@BB@BB@D@B@@@@A@A@ABA@@@AMICE@A@@@AB@B@FCBAF@DADADEBCBABADEDEFIBCFI@AAE@EAEAA@ABGBADE@A@@AA@AB@BCBCB@@A@AAE@C@A@ADGAAACBA@CBEBABA@A@A@@BCBC@C@AB@BC@@AA@AA@@A@@D@F@B@DBB@FAB@BA@@@AECAA@A@C@A@ABCBG@ABADA@A@@@ACAAC@@@A@A@@BABADCBABA@@AA@A@A@CC@C@A@KF@@A@ABAB@AC@G@S@gDQAQ@C@UGCIDIFGJEDAFI@@@@@AFMAIAI@GBKBA@CDACGZGACD@@A\\G@AJCDAB@@@@A@@@@@ADA@@@@@@@AB@B@@@DBBBDBB@@@BA@@AEBA@@B@F@DACCAA@AFDDBAEA@@A@@B@B@@@F@D@@@@CAC@@BAD@FADAB@BAFA@@BA@AAA@@HCDAJCHO@@@@CEVE@DBD@D@@B@HCBAB@@E@EB@@E@@C@@EAAAC@@BABADCD@B@DBD@@BFAB@D@D@B@B@DAHBL@DBD@B@BADEBABA@@"],"encodeOffsets":[[125543,42770]]}}],"UTF8Encoding":true});}));