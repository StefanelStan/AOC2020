package com.ss.aoc;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Day04 {
    private String inputData = "eyr:2029 pid:157374862\n" +
            "byr:1991 ecl:amb hcl:#a97842 hgt:178cm\n" +
            "\n" +
            "byr:1962 pid:547578491 eyr:2028 ecl:hzl hgt:65in iyr:2013 hcl:#623a2f\n" +
            "\n" +
            "hgt:71in eyr:2037\n" +
            "ecl:#8e276e hcl:z iyr:2019\n" +
            "byr:2022 pid:157cm\n" +
            "\n" +
            "hcl:#733820 hgt:175 eyr:2028 iyr:2011\n" +
            "pid:87786389\n" +
            "ecl:hzl byr:1980\n" +
            "\n" +
            "hgt:163in hcl:z pid:8261494508 cid:136 ecl:grn eyr:1958\n" +
            "byr:2030 iyr:1991\n" +
            "\n" +
            "iyr:2021\n" +
            "hcl:6708a3\n" +
            "ecl:zzz eyr:2034 byr:2010\n" +
            "hgt:189cm\n" +
            "pid:466438311\n" +
            "\n" +
            "iyr:2012 pid:9720867166 byr:2006 eyr:2022 hgt:72cm ecl:utc hcl:#c0946f\n" +
            "\n" +
            "ecl:#353bc9\n" +
            "iyr:2020 pid:874363951 cid:113\n" +
            "hcl:z eyr:2040 hgt:76in byr:1975\n" +
            "\n" +
            "eyr:1971\n" +
            "byr:1955 pid:193cm hgt:189cm hcl:#ceb3a1 ecl:grn\n" +
            "iyr:2023\n" +
            "\n" +
            "byr:2014\n" +
            "iyr:2026 eyr:1978 hcl:z cid:312 pid:8294818417\n" +
            "hgt:169in ecl:#82bb02\n" +
            "\n" +
            "ecl:amb\n" +
            "byr:1936 hcl:#7d3b0c pid:429853734\n" +
            "cid:342 iyr:2010 eyr:2025 hgt:160cm\n" +
            "\n" +
            "byr:2025 hgt:176in hcl:a490ac\n" +
            "ecl:#956d3f iyr:2027\n" +
            "eyr:2021 pid:9858101884\n" +
            "\n" +
            "hgt:142 pid:175cm\n" +
            "eyr:1952 byr:2004 iyr:2007 ecl:#da035e hcl:#623a2f\n" +
            "cid:194\n" +
            "\n" +
            "hgt:156cm\n" +
            "pid:349122810 hcl:#b6652a eyr:2026 byr:1948 ecl:lzr iyr:2020\n" +
            "\n" +
            "byr:1997 ecl:blu\n" +
            "hcl:#888785 pid:381094641 iyr:2014 hgt:192cm eyr:2027\n" +
            "\n" +
            "hcl:7b10a2 ecl:lzr byr:2022\n" +
            "eyr:2035\n" +
            "pid:#38b715 hgt:190in iyr:2029\n" +
            "\n" +
            "pid:188cm byr:2014\n" +
            "cid:241 ecl:#dda9bd hcl:#8f6ebc\n" +
            "hgt:188cm iyr:2014 eyr:2029\n" +
            "\n" +
            "hgt:76cm ecl:gmt hcl:z iyr:2024\n" +
            "pid:3283057785\n" +
            "byr:2019 eyr:2026\n" +
            "\n" +
            "iyr:2010 pid:284327216 hgt:191cm\n" +
            "byr:1970\n" +
            "hcl:#18171d\n" +
            "ecl:grn\n" +
            "eyr:2023\n" +
            "\n" +
            "byr:1929 eyr:2026 cid:194 ecl:oth hgt:156cm pid:224596482 hcl:#b6652a iyr:2013\n" +
            "\n" +
            "eyr:2030 byr:1958 hgt:190cm\n" +
            "pid:162950579 iyr:2010\n" +
            "ecl:brn\n" +
            "cid:250 hcl:#fffffd\n" +
            "\n" +
            "ecl:xry iyr:2025 pid:#0155c1\n" +
            "hcl:#341e13\n" +
            "eyr:2027 hgt:163cm byr:2025\n" +
            "\n" +
            "hcl:#602927 pid:908859481 byr:1962 ecl:hzl\n" +
            "iyr:2021 eyr:2028 hgt:180cm\n" +
            "\n" +
            "iyr:1966 eyr:1976 pid:#bbfe21 hcl:63454a cid:259\n" +
            "ecl:blu\n" +
            "byr:2024 hgt:69cm\n" +
            "\n" +
            "ecl:#644daf\n" +
            "byr:2021 eyr:2040\n" +
            "hcl:bc83fe\n" +
            "iyr:1976 hgt:59in pid:60311335\n" +
            "\n" +
            "iyr:2018\n" +
            "pid:121801570 hgt:182cm ecl:blu byr:1922 cid:265 eyr:2024 hcl:#888785\n" +
            "\n" +
            "byr:1933\n" +
            "pid:232653422 ecl:gry hcl:#18171d\n" +
            "hgt:171cm eyr:2035 iyr:2011\n" +
            "\n" +
            "ecl:oth iyr:2015 byr:1937\n" +
            "pid:828621370 hcl:#602927\n" +
            "eyr:2026\n" +
            "hgt:193cm\n" +
            "\n" +
            "iyr:2010 ecl:grn eyr:2022\n" +
            "hcl:af37d1 pid:761632482 hgt:65in cid:93\n" +
            "byr:1993\n" +
            "\n" +
            "hgt:169cm cid:121\n" +
            "iyr:2018\n" +
            "hcl:#6b5442\n" +
            "pid:059725560 ecl:oth\n" +
            "byr:1972 eyr:2028\n" +
            "\n" +
            "eyr:2024 byr:2023 ecl:gry\n" +
            "iyr:2017\n" +
            "pid:778551716 cid:256 hcl:#733820 hgt:184cm\n" +
            "\n" +
            "hcl:#ceb3a1 pid:613277258 byr:1941 hgt:67cm eyr:2029\n" +
            "ecl:hzl\n" +
            "iyr:2017\n" +
            "\n" +
            "ecl:hzl iyr:2012 pid:498418959 eyr:2022\n" +
            "byr:1929 hgt:164cm hcl:#a97842 cid:226\n" +
            "\n" +
            "hgt:157cm eyr:2029\n" +
            "byr:1922 iyr:2014 ecl:grn cid:233 hcl:#888785 pid:802870003\n" +
            "\n" +
            "hgt:184cm\n" +
            "ecl:oth hcl:#888785 iyr:2010 byr:1929 eyr:2030\n" +
            "pid:063671905\n" +
            "\n" +
            "hcl:#888785 hgt:144 eyr:1961\n" +
            "iyr:2005\n" +
            "byr:2027\n" +
            "cid:164 pid:41787324\n" +
            "ecl:utc\n" +
            "\n" +
            "hcl:#7d3b0c\n" +
            "pid:570743051 byr:2022 eyr:1975\n" +
            "iyr:2018 ecl:utc hgt:188in\n" +
            "\n" +
            "eyr:2028 pid:970460968\n" +
            "hgt:161cm\n" +
            "iyr:2017 ecl:amb\n" +
            "cid:318 byr:1967 hcl:#cfa07d\n" +
            "\n" +
            "hgt:183cm eyr:2036 hcl:070713 iyr:1959\n" +
            "cid:242 byr:2011 pid:#0855a5 ecl:lzr\n" +
            "\n" +
            "hcl:#ceb3a1 eyr:2023 iyr:2016\n" +
            "ecl:oth hgt:84\n" +
            "pid:156cm byr:1949\n" +
            "\n" +
            "eyr:2025 ecl:brn hgt:172cm pid:487559063 iyr:2013\n" +
            "hcl:#efcc98\n" +
            "byr:1985\n" +
            "\n" +
            "eyr:2023 hcl:#6b5442 byr:2021 hgt:75cm iyr:1943\n" +
            "pid:427375038 ecl:#70c167\n" +
            "\n" +
            "ecl:hzl\n" +
            "eyr:2028 byr:1957 iyr:2010\n" +
            "hcl:#602927\n" +
            "hgt:151cm pid:755290924\n" +
            "\n" +
            "cid:184 hgt:172cm\n" +
            "pid:7056500139 iyr:2016 byr:2016\n" +
            "hcl:e40e08 ecl:#d21247\n" +
            "\n" +
            "ecl:oth\n" +
            "eyr:2025\n" +
            "iyr:2010 byr:1971 cid:128 pid:932834922\n" +
            "hcl:#602927\n" +
            "hgt:167cm\n" +
            "\n" +
            "ecl:brn hgt:61in iyr:2016 hcl:#341e13\n" +
            "pid:918193693 byr:1972 eyr:2029 cid:56\n" +
            "\n" +
            "byr:1956 iyr:2020 eyr:2030 hgt:72in\n" +
            "pid:179969841\n" +
            "ecl:blu\n" +
            "\n" +
            "ecl:#09fd92 cid:209 hgt:69cm iyr:2014\n" +
            "eyr:2028 pid:#2ad9c0 hcl:#b6652a\n" +
            "byr:2012\n" +
            "\n" +
            "ecl:lzr byr:1980 cid:104\n" +
            "iyr:1965 pid:57029893 hcl:z\n" +
            "eyr:2030 hgt:64cm\n" +
            "\n" +
            "pid:496149551\n" +
            "hcl:#6b5442 hgt:181cm byr:1978 iyr:2017\n" +
            "eyr:2026\n" +
            "cid:291 ecl:hzl\n" +
            "\n" +
            "iyr:2018 hcl:#ceb3a1\n" +
            "eyr:2021 cid:183 pid:612653062\n" +
            "ecl:oth\n" +
            "byr:1982\n" +
            "\n" +
            "hgt:153cm pid:877597531 ecl:gry\n" +
            "iyr:2014 hcl:#866857 cid:333\n" +
            "byr:1953\n" +
            "eyr:2022\n" +
            "\n" +
            "iyr:2015\n" +
            "ecl:brn\n" +
            "pid:823959694 byr:1998 hcl:#18171d\n" +
            "eyr:2025 hgt:174cm\n" +
            "\n" +
            "iyr:2012 cid:93\n" +
            "ecl:oth pid:142618419 byr:1955 hgt:193cm eyr:1977 hcl:#602927\n" +
            "\n" +
            "hcl:z ecl:dne iyr:1926 eyr:2026 pid:175cm hgt:150 byr:2023 cid:234\n" +
            "\n" +
            "hgt:61cm iyr:1965 byr:1956\n" +
            "pid:224946350 cid:105\n" +
            "eyr:1951 hcl:#733820 ecl:amb\n" +
            "\n" +
            "hcl:#866857\n" +
            "byr:1970 pid:447859408\n" +
            "eyr:2030\n" +
            "hgt:65in iyr:2011 ecl:grn\n" +
            "\n" +
            "cid:184 eyr:1976 byr:2021 hgt:187cm\n" +
            "pid:858786336 ecl:#0d63e1 hcl:z\n" +
            "\n" +
            "hgt:178cm iyr:1986 hcl:51ac0c ecl:dne eyr:2023 pid:180cm\n" +
            "\n" +
            "hcl:#cfa07d pid:002093179\n" +
            "ecl:oth\n" +
            "byr:1983 hgt:159cm iyr:2016 eyr:2025\n" +
            "\n" +
            "ecl:gry hcl:#c0946f\n" +
            "byr:2009 pid:#e00fc8\n" +
            "hgt:62in cid:150 iyr:2013 eyr:1957\n" +
            "\n" +
            "byr:1942 ecl:oth eyr:2020 pid:765036664 hcl:#6b5442 iyr:2015 cid:155\n" +
            "\n" +
            "ecl:hzl iyr:2014\n" +
            "hcl:#efcc98 hgt:179cm eyr:2028\n" +
            "byr:1921 pid:#666905\n" +
            "\n" +
            "ecl:utc eyr:2040 hcl:669f5b pid:981368190\n" +
            "byr:2006 iyr:1949\n" +
            "hgt:179in\n" +
            "\n" +
            "ecl:#062fcd eyr:2035 byr:1962 iyr:2026 hcl:z hgt:161cm pid:75591618\n" +
            "\n" +
            "hcl:#b25ef5 pid:434943296\n" +
            "ecl:oth hgt:165cm\n" +
            "iyr:2013 eyr:2020\n" +
            "cid:78 byr:1924\n" +
            "\n" +
            "iyr:2018 ecl:oth byr:1972 eyr:2028 pid:035313920\n" +
            "hgt:59in hcl:#fffffd\n" +
            "\n" +
            "hgt:185cm\n" +
            "hcl:#6b5442\n" +
            "cid:102 iyr:2020 byr:2001\n" +
            "eyr:2028 pid:003365121 ecl:amb\n" +
            "\n" +
            "pid:90937712 hcl:z hgt:173in byr:2012 ecl:blu iyr:2009 eyr:2039\n" +
            "\n" +
            "pid:509460932 eyr:2026\n" +
            "hgt:71in iyr:2010 cid:138 byr:1929 ecl:grn\n" +
            "\n" +
            "ecl:xry\n" +
            "hgt:119\n" +
            "pid:051834447 eyr:2033\n" +
            "iyr:2030 hcl:z byr:2030\n" +
            "\n" +
            "pid:443984745 eyr:2026 ecl:oth\n" +
            "byr:1948 hcl:#a97842 hgt:168cm\n" +
            "iyr:2017\n" +
            "\n" +
            "hcl:#602927 iyr:2020 cid:161 pid:069708283 hgt:178cm byr:1960\n" +
            "eyr:2022 ecl:hzl\n" +
            "\n" +
            "iyr:2026 hcl:766b30 eyr:2032 byr:2030 pid:40361792 hgt:158in ecl:#b300dc\n" +
            "\n" +
            "eyr:1998 pid:#5c21e4 iyr:2029 ecl:#bef182\n" +
            "byr:1944 hgt:166in\n" +
            "hcl:#b6652a cid:317\n" +
            "\n" +
            "ecl:amb\n" +
            "eyr:2024\n" +
            "hcl:#a97842\n" +
            "pid:086765271 hgt:183cm iyr:2018 cid:314 byr:2001\n" +
            "\n" +
            "hgt:163in pid:491612094 iyr:2028\n" +
            "cid:82 ecl:#8a052d\n" +
            "hcl:#ceb3a1\n" +
            "eyr:2018\n" +
            "\n" +
            "byr:1970 eyr:2039\n" +
            "hgt:174in hcl:#623a2f\n" +
            "iyr:2020 cid:154 ecl:grn pid:103138652\n" +
            "\n" +
            "pid:73895324 eyr:2026 byr:1952 ecl:brn hcl:#733820 hgt:159in iyr:2015\n" +
            "\n" +
            "hcl:#623a2f ecl:brn eyr:2026 hgt:185cm pid:791563822 iyr:2019 byr:1951\n" +
            "\n" +
            "hcl:#fffffd\n" +
            "iyr:2014 hgt:83 cid:101 pid:724483094\n" +
            "eyr:1995 byr:2015 ecl:lzr\n" +
            "\n" +
            "hcl:#ceb3a1\n" +
            "iyr:2013\n" +
            "eyr:2021 byr:1994 ecl:hzl\n" +
            "pid:037849486 hgt:60in\n" +
            "\n" +
            "pid:63340670 iyr:1995 hcl:b54c2b hgt:71cm\n" +
            "cid:184 byr:2004 ecl:dne eyr:2026\n" +
            "\n" +
            "hgt:169cm\n" +
            "ecl:brn byr:1947 iyr:2014 cid:224 hcl:#7374df\n" +
            "\n" +
            "hcl:#623a2f\n" +
            "pid:471948403 ecl:gry\n" +
            "hgt:154cm\n" +
            "eyr:2023 iyr:2016 byr:1925\n" +
            "\n" +
            "eyr:2024 hgt:180cm hcl:#efcc98 iyr:2020 ecl:gry byr:1961 pid:318184801\n" +
            "\n" +
            "ecl:blu iyr:2012 eyr:2020 hgt:190cm\n" +
            "byr:1977\n" +
            "pid:331654452 hcl:#cfa07d\n" +
            "\n" +
            "pid:812502106 byr:1938\n" +
            "eyr:2020 hgt:169cm ecl:oth hcl:#341e13 iyr:2011\n" +
            "\n" +
            "cid:286 byr:1942 eyr:2034 hgt:116\n" +
            "ecl:utc\n" +
            "iyr:2023 hcl:#602927 pid:181cm\n" +
            "\n" +
            "ecl:amb iyr:2011 hcl:#cfa07d eyr:2029 byr:1975\n" +
            "hgt:183cm pid:548900689\n" +
            "\n" +
            "ecl:utc pid:182cm\n" +
            "hgt:60cm\n" +
            "eyr:1989 iyr:1993 hcl:z\n" +
            "\n" +
            "iyr:1985 hgt:186 byr:2018\n" +
            "eyr:2001 pid:9257131167\n" +
            "hcl:261a65 ecl:lzr\n" +
            "\n" +
            "hgt:152\n" +
            "byr:1922 pid:72992226\n" +
            "iyr:1968\n" +
            "ecl:dne eyr:2028 hcl:5c2950\n" +
            "\n" +
            "ecl:grn\n" +
            "byr:1943 hgt:74in eyr:2022\n" +
            "pid:135491924\n" +
            "iyr:2011 hcl:#623a2f\n" +
            "\n" +
            "iyr:2026 pid:7955389103\n" +
            "cid:311\n" +
            "ecl:#b81171 hcl:z eyr:1935 byr:2024\n" +
            "\n" +
            "byr:1974 iyr:2010 hgt:165cm\n" +
            "ecl:amb cid:343 eyr:2023\n" +
            "pid:972786259 hcl:#6b5442\n" +
            "\n" +
            "iyr:2020 byr:1936\n" +
            "ecl:gry hcl:#efcc98 hgt:170cm eyr:2021 pid:520354073\n" +
            "\n" +
            "hgt:185cm hcl:#ceb3a1\n" +
            "pid:317012754 byr:1991\n" +
            "cid:199 iyr:2011\n" +
            "ecl:blu eyr:2028\n" +
            "\n" +
            "ecl:#e4e01f byr:2008\n" +
            "cid:293 iyr:2013 hcl:z pid:#368f7a eyr:2036\n" +
            "\n" +
            "eyr:2022 pid:424388475 iyr:2008 hcl:z hgt:61cm\n" +
            "ecl:zzz byr:1985\n" +
            "\n" +
            "hcl:#18171d iyr:2014\n" +
            "cid:88\n" +
            "byr:1951 eyr:2021 pid:812441789 hgt:181cm ecl:blu\n" +
            "\n" +
            "ecl:amb eyr:2029 hgt:70in pid:580245172\n" +
            "iyr:2010 byr:1927\n" +
            "hcl:#a97842\n" +
            "cid:284\n" +
            "\n" +
            "hcl:#3b85ed\n" +
            "ecl:gry eyr:2029 pid:417534919 byr:1960\n" +
            "iyr:2010 hgt:71in\n" +
            "\n" +
            "hcl:#c0946f\n" +
            "pid:824103775 hgt:157cm iyr:2018 ecl:brn eyr:2024 byr:1961\n" +
            "\n" +
            "pid:673501373\n" +
            "eyr:2033\n" +
            "ecl:#06523f hcl:z byr:2030 iyr:1978 hgt:153cm\n" +
            "\n" +
            "iyr:2019\n" +
            "hcl:#a97842 byr:1951 hgt:183cm eyr:2024 ecl:blu\n" +
            "pid:346079429\n" +
            "\n" +
            "eyr:1937 pid:964649406\n" +
            "hgt:162\n" +
            "cid:66\n" +
            "ecl:#f89cc0\n" +
            "hcl:#866857 byr:2024\n" +
            "\n" +
            "hgt:114 ecl:#e7ed3a\n" +
            "byr:2029 cid:190\n" +
            "eyr:2026 iyr:1986 hcl:z pid:185cm\n" +
            "\n" +
            "hcl:#cfa07d hgt:192cm\n" +
            "pid:12494711 eyr:2028\n" +
            "iyr:2020\n" +
            "ecl:brn byr:2004\n" +
            "\n" +
            "pid:710015269\n" +
            "byr:2011 eyr:2033 hgt:181cm\n" +
            "ecl:#fb2702\n" +
            "\n" +
            "cid:259 pid:208799387\n" +
            "eyr:2025 hcl:#623a2f byr:1947 ecl:oth hgt:164cm iyr:2014\n" +
            "\n" +
            "ecl:brn eyr:2025 pid:432178809 hcl:#341e13\n" +
            "cid:50\n" +
            "hgt:192cm iyr:2012\n" +
            "byr:1994\n" +
            "\n" +
            "hgt:150in pid:4902585462 ecl:#7074ad cid:230 iyr:2019 eyr:1931 hcl:z byr:2007\n" +
            "\n" +
            "ecl:gry\n" +
            "byr:1942\n" +
            "hcl:#602927 cid:178 iyr:2014 hgt:193cm pid:349100081 eyr:2030\n" +
            "\n" +
            "byr:1923 hcl:#cfa07d eyr:2021 ecl:brn pid:591544598 hgt:157cm\n" +
            "iyr:2016\n" +
            "\n" +
            "hcl:e15737\n" +
            "iyr:2017 byr:2030\n" +
            "eyr:1994 pid:470833249\n" +
            "hgt:181cm cid:70 ecl:grn\n" +
            "\n" +
            "eyr:2030\n" +
            "hcl:#866857 pid:569423049 byr:1948\n" +
            "ecl:oth\n" +
            "\n" +
            "eyr:2026\n" +
            "byr:2006\n" +
            "hcl:#ceb3a1\n" +
            "iyr:2010 pid:094156115 hgt:64cm ecl:oth\n" +
            "\n" +
            "byr:2002 cid:215 ecl:hzl\n" +
            "hcl:#602927 iyr:2015 pid:53150410 hgt:168cm eyr:2028\n" +
            "\n" +
            "iyr:2016 hcl:#7d3b0c hgt:162cm\n" +
            "byr:1937 eyr:2020 ecl:hzl pid:728906226\n" +
            "\n" +
            "byr:1921\n" +
            "iyr:2018 hcl:#888785\n" +
            "eyr:2026 hgt:185cm pid:164432370 ecl:brn\n" +
            "\n" +
            "ecl:gry iyr:2011\n" +
            "eyr:2026 hgt:190cm\n" +
            "hcl:#866857 pid:884570088 byr:1996\n" +
            "\n" +
            "ecl:blu\n" +
            "cid:257\n" +
            "iyr:2016 byr:1989\n" +
            "eyr:2024 hgt:179cm hcl:#c0946f pid:418340261\n" +
            "\n" +
            "pid:9367990743 hcl:z hgt:182in ecl:utc\n" +
            "byr:1988 eyr:2025\n" +
            "\n" +
            "ecl:hzl hgt:157cm\n" +
            "iyr:2010 eyr:2027\n" +
            "hcl:#fffffd byr:1956\n" +
            "\n" +
            "eyr:2024 pid:834302242 ecl:hzl\n" +
            "iyr:2015 cid:97 hgt:188cm hcl:#888785 byr:1927\n" +
            "\n" +
            "ecl:brn eyr:2021 byr:1958\n" +
            "hcl:#a97842 hgt:170cm pid:256795932 iyr:2017\n" +
            "\n" +
            "hcl:756c4a\n" +
            "pid:812879747\n" +
            "byr:2002\n" +
            "eyr:2027 ecl:blu iyr:1952 hgt:66cm\n" +
            "\n" +
            "pid:#c5e14f\n" +
            "iyr:2026 byr:2028 hgt:162 hcl:87ba57\n" +
            "eyr:1952 ecl:lzr\n" +
            "\n" +
            "hcl:#341e13 hgt:81 eyr:2021 iyr:2029 cid:262 ecl:amb pid:61006868\n" +
            "byr:2011\n" +
            "\n" +
            "pid:#e58702 cid:145 hcl:#866857\n" +
            "ecl:grn iyr:2028 hgt:192in eyr:2025 byr:2017\n" +
            "\n" +
            "iyr:2026 byr:1969\n" +
            "ecl:grn\n" +
            "hgt:70cm cid:140 hcl:e0f231 eyr:2027\n" +
            "pid:2832019\n" +
            "\n" +
            "cid:112 eyr:2028 iyr:2018 hcl:#7d3b0c pid:868808117 byr:1985 ecl:blu\n" +
            "\n" +
            "iyr:2017\n" +
            "pid:350399038\n" +
            "cid:72 hcl:#ceb3a1\n" +
            "ecl:gry\n" +
            "hgt:151cm byr:1946 eyr:2029\n" +
            "\n" +
            "eyr:2026 hgt:174cm iyr:2010 pid:534641153 hcl:#733820 byr:1965\n" +
            "\n" +
            "hgt:66cm\n" +
            "byr:2010 ecl:gmt eyr:2039\n" +
            "iyr:2024 hcl:z\n" +
            "\n" +
            "pid:626085326\n" +
            "byr:1971 eyr:2024\n" +
            "hcl:#cfa07d hgt:170cm\n" +
            "ecl:hzl iyr:2019\n" +
            "\n" +
            "hgt:185cm pid:995661846 ecl:hzl iyr:2016 byr:1963 hcl:#a97842 eyr:2023\n" +
            "\n" +
            "ecl:grt iyr:1976 byr:2010\n" +
            "pid:170cm\n" +
            "cid:343 hcl:#7d3b0c hgt:171cm\n" +
            "\n" +
            "pid:732695396\n" +
            "ecl:zzz hgt:151in byr:1955\n" +
            "eyr:2035 iyr:2026 hcl:z\n" +
            "\n" +
            "hgt:187cm hcl:#341e13 iyr:2015 pid:556697270 eyr:2025 ecl:blu byr:1926\n" +
            "\n" +
            "ecl:oth\n" +
            "pid:515980529\n" +
            "hgt:168cm eyr:2023\n" +
            "byr:1983 iyr:2012 hcl:#341e13\n" +
            "\n" +
            "byr:2010\n" +
            "hgt:189cm iyr:2016\n" +
            "hcl:#8ff71e\n" +
            "eyr:2010\n" +
            "ecl:blu\n" +
            "pid:317940449\n" +
            "\n" +
            "iyr:2013 hgt:157cm hcl:#a97842 pid:967988435\n" +
            "ecl:blu cid:214 eyr:2027 byr:1960\n" +
            "\n" +
            "pid:2666548509 cid:208 hgt:72cm hcl:#7d3b0c eyr:2040 byr:2008\n" +
            "ecl:amb\n" +
            "iyr:1926\n" +
            "\n" +
            "eyr:2039\n" +
            "pid:203432895 hgt:154cm byr:1949\n" +
            "iyr:2010\n" +
            "hcl:z cid:144 ecl:xry\n" +
            "\n" +
            "pid:984689798 byr:2016 iyr:1999 ecl:utc\n" +
            "eyr:2037 hgt:68cm hcl:z\n" +
            "\n" +
            "byr:1969 cid:230 hgt:72cm eyr:2032\n" +
            "ecl:gry pid:849701444\n" +
            "hcl:#c0946f\n" +
            "iyr:2012\n" +
            "\n" +
            "eyr:2026\n" +
            "pid:588870142\n" +
            "hcl:#ae5619 hgt:173cm\n" +
            "cid:189\n" +
            "ecl:grn byr:1996 iyr:2013\n" +
            "\n" +
            "byr:1973\n" +
            "hcl:#cfa07d ecl:blu\n" +
            "hgt:193cm eyr:2028 cid:115 pid:786380485 iyr:2011\n" +
            "\n" +
            "hcl:#fffffd eyr:2028 hgt:155cm pid:499022582\n" +
            "ecl:blu byr:1977 iyr:2014\n" +
            "cid:212\n" +
            "\n" +
            "ecl:#92bb4b\n" +
            "pid:815154669 byr:1923 eyr:2023\n" +
            "hgt:183cm iyr:1929 hcl:#ceb3a1\n" +
            "\n" +
            "byr:1966 eyr:2021 iyr:2020 hcl:#6b5442 ecl:hzl\n" +
            "pid:3508035599\n" +
            "hgt:70in\n" +
            "\n" +
            "ecl:amb\n" +
            "hcl:#18171d\n" +
            "byr:1927\n" +
            "hgt:177cm pid:555764540 iyr:2018 eyr:2025 cid:90\n" +
            "\n" +
            "hgt:139 ecl:#878a7d byr:2006 cid:275 iyr:1980 hcl:60fca6 eyr:1952 pid:001439727\n" +
            "\n" +
            "byr:1985\n" +
            "hgt:174cm ecl:gry\n" +
            "iyr:2018\n" +
            "cid:204 hcl:#733820\n" +
            "pid:141048398 eyr:2027\n" +
            "\n" +
            "ecl:gmt hcl:#6b5442 hgt:158cm\n" +
            "iyr:2025\n" +
            "byr:2030 pid:966397365 eyr:2029\n" +
            "\n" +
            "byr:1962 hgt:166cm pid:261989937 cid:320 eyr:2026\n" +
            "iyr:2015 hcl:#c0946f\n" +
            "ecl:hzl\n" +
            "\n" +
            "pid:852283506 iyr:2018 eyr:2020 byr:1981 hcl:#733820\n" +
            "ecl:hzl\n" +
            "hgt:162cm\n" +
            "\n" +
            "pid:3873488100 iyr:1982 ecl:grn\n" +
            "hgt:63cm eyr:1936\n" +
            "byr:2011 hcl:8d118a\n" +
            "\n" +
            "iyr:1937\n" +
            "hcl:817646\n" +
            "byr:2026 eyr:2031 pid:#47591d hgt:183in\n" +
            "ecl:blu\n" +
            "\n" +
            "eyr:2025 hgt:153cm iyr:2015 pid:498382864\n" +
            "cid:307\n" +
            "byr:1943\n" +
            "hcl:#f66fe1 ecl:oth\n" +
            "\n" +
            "iyr:2017 hgt:66in byr:1948 hcl:#b6652a eyr:2025\n" +
            "pid:188366364\n" +
            "ecl:amb\n" +
            "\n" +
            "ecl:lzr\n" +
            "pid:453174702 iyr:2028 eyr:2032 cid:228 byr:2011 hcl:z\n" +
            "hgt:172cm\n" +
            "\n" +
            "hgt:186cm eyr:2030 cid:316 hcl:z byr:1994\n" +
            "iyr:2012 ecl:amb pid:993162839\n" +
            "\n" +
            "hgt:160cm\n" +
            "ecl:grn pid:523473760 byr:1993\n" +
            "iyr:2016 eyr:2025 hcl:#602927 cid:261\n" +
            "\n" +
            "iyr:2016 pid:520973843 ecl:gry\n" +
            "eyr:2023 cid:232\n" +
            "byr:1944 hgt:159cm hcl:#cfa07d\n" +
            "\n" +
            "byr:1969 hcl:#1d37de hgt:184cm eyr:2027 pid:088048141\n" +
            "iyr:2016 cid:307 ecl:hzl\n" +
            "\n" +
            "eyr:2040 iyr:2012 pid:723592140\n" +
            "hgt:61cm hcl:#18171d ecl:dne\n" +
            "\n" +
            "eyr:2025\n" +
            "ecl:oth pid:4697392468\n" +
            "hgt:183cm iyr:2017 hcl:b07d71\n" +
            "byr:1996\n" +
            "\n" +
            "ecl:amb eyr:2022 cid:143 pid:806594272 hgt:158cm byr:1977 iyr:2014\n" +
            "hcl:#866857\n" +
            "\n" +
            "ecl:blu\n" +
            "eyr:2022 iyr:2018 byr:1983 hgt:167cm cid:321 hcl:#efcc98\n" +
            "pid:344179526\n" +
            "\n" +
            "byr:1925 eyr:2021\n" +
            "hgt:193cm iyr:2020 ecl:grn\n" +
            "hcl:#888785\n" +
            "\n" +
            "iyr:2018\n" +
            "cid:319 byr:1972 hgt:181cm hcl:#fffffd eyr:2023 pid:493780616\n" +
            "\n" +
            "eyr:2021\n" +
            "hcl:#733820\n" +
            "ecl:#e91c71\n" +
            "iyr:2020 pid:451676066 hgt:166in\n" +
            "byr:1993\n" +
            "\n" +
            "eyr:2026\n" +
            "hcl:#b6652a ecl:blu byr:1999 iyr:2020\n" +
            "hgt:163cm pid:955741810\n" +
            "\n" +
            "iyr:2016 hgt:179cm hcl:#602927\n" +
            "pid:673271332 byr:1963 eyr:2027 ecl:amb\n" +
            "\n" +
            "byr:1927\n" +
            "iyr:2015 hcl:#866857\n" +
            "ecl:oth\n" +
            "hgt:159cm\n" +
            "pid:992992996 eyr:2030\n" +
            "\n" +
            "pid:283188332 hgt:168cm hcl:#6b5442\n" +
            "eyr:2027 byr:2028 ecl:hzl iyr:2030\n" +
            "\n" +
            "byr:1944 pid:628012522 eyr:2020\n" +
            "hcl:#866857\n" +
            "iyr:2019 ecl:amb\n" +
            "hgt:168cm\n" +
            "\n" +
            "cid:317 pid:333228098 hgt:158cm iyr:2014 byr:1958 eyr:2024 hcl:#a97842 ecl:oth\n" +
            "\n" +
            "hcl:#733820\n" +
            "cid:314 ecl:oth byr:1938 eyr:2030 hgt:71in\n" +
            "pid:790938694 iyr:2014\n" +
            "\n" +
            "iyr:2020 ecl:grt eyr:2018\n" +
            "hgt:155cm\n" +
            "pid:1034925815 hcl:#623a2f cid:304\n" +
            "\n" +
            "ecl:brn hgt:158cm hcl:#38fe6c eyr:2030 byr:1926 pid:0860404500 iyr:1993 cid:348\n" +
            "\n" +
            "byr:1998\n" +
            "hgt:185cm\n" +
            "ecl:brn eyr:2021 pid:567032567 hcl:#733820 cid:328 iyr:2017\n" +
            "\n" +
            "pid:491430863 cid:146 hgt:181cm eyr:2026 iyr:2015 ecl:amb byr:1950 hcl:#c0946f\n" +
            "\n" +
            "eyr:2033 cid:289\n" +
            "pid:396679011 ecl:oth byr:1988\n" +
            "hgt:156in\n" +
            "hcl:#cfa07d iyr:2029\n" +
            "\n" +
            "ecl:grn iyr:2015\n" +
            "byr:1986 hcl:#a97842 hgt:62in\n" +
            "pid:403990108 eyr:2030\n" +
            "\n" +
            "pid:42635067 cid:301\n" +
            "iyr:2027 hgt:173in\n" +
            "byr:2004 hcl:z\n" +
            "eyr:2034\n" +
            "\n" +
            "byr:2020 hcl:#fffffd\n" +
            "hgt:180in eyr:2040 pid:304951921\n" +
            "iyr:2030 ecl:#1aaf20\n" +
            "\n" +
            "iyr:2020 hcl:#888785 ecl:hzl hgt:181cm byr:1992 eyr:2021 pid:936006959\n" +
            "\n" +
            "hgt:172in ecl:#fd71a7\n" +
            "hcl:787715 pid:363058480 byr:2020\n" +
            "iyr:2022\n" +
            "eyr:2034\n" +
            "\n" +
            "iyr:2018 ecl:blu eyr:2029 hcl:#cfa07d hgt:155cm byr:1937 pid:851148031\n" +
            "\n" +
            "byr:2014\n" +
            "cid:222 ecl:zzz hgt:67cm eyr:2040 pid:#8ab0e2 hcl:z iyr:2027\n" +
            "\n" +
            "hgt:180cm hcl:#375883 eyr:2027 byr:1925 ecl:brn\n" +
            "iyr:2011\n" +
            "pid:158752719\n" +
            "\n" +
            "byr:1935 ecl:oth eyr:2027 pid:041108579\n" +
            "hcl:#602927 iyr:2011 hgt:190cm\n" +
            "\n" +
            "hcl:#a97842 pid:131728607 ecl:blu iyr:2014 hgt:176cm eyr:2020\n" +
            "byr:1921\n" +
            "\n" +
            "pid:11754457\n" +
            "iyr:2018\n" +
            "hgt:65cm eyr:2038\n" +
            "ecl:dne hcl:z\n" +
            "cid:293\n" +
            "byr:1940\n" +
            "\n" +
            "eyr:2023\n" +
            "iyr:2016\n" +
            "byr:1930\n" +
            "ecl:hzl\n" +
            "cid:212\n" +
            "hcl:#733820 hgt:59in\n" +
            "pid:319501919\n" +
            "\n" +
            "cid:278\n" +
            "eyr:1967 hcl:#ceb3a1 pid:#9f5254 hgt:177in byr:1977 iyr:2030\n" +
            "\n" +
            "hcl:#ceb3a1 byr:1998 hgt:72in cid:202 ecl:gry pid:463378493 iyr:2015\n" +
            "eyr:2030\n" +
            "\n" +
            "hcl:#7d3b0c hgt:164cm ecl:hzl byr:1960 eyr:2023\n" +
            "iyr:2017\n" +
            "\n" +
            "ecl:hzl hcl:#866857 byr:1986 iyr:2018 eyr:2027 hgt:176cm pid:928057092\n" +
            "\n" +
            "pid:431113230 hgt:186cm eyr:2025\n" +
            "iyr:2018 ecl:amb byr:1973 hcl:#623a2f\n" +
            "\n" +
            "hcl:#cfa07d hgt:179cm iyr:2017 pid:760075190 ecl:amb eyr:2030\n" +
            "\n" +
            "hcl:#602927\n" +
            "iyr:2012\n" +
            "pid:571020910 ecl:#b6715d byr:1943 eyr:2028\n" +
            "hgt:161cm\n" +
            "\n" +
            "hgt:176cm cid:121 pid:654127593 ecl:brn hcl:#160d38 iyr:2015\n" +
            "eyr:2021 byr:1997\n" +
            "\n" +
            "eyr:2021 byr:1929\n" +
            "pid:192025713\n" +
            "hcl:#c0946f iyr:2012 ecl:oth hgt:179cm\n" +
            "\n" +
            "eyr:2024 ecl:gry\n" +
            "hgt:158cm byr:1932 hcl:#ceb3a1\n" +
            "iyr:2010\n" +
            "pid:521188306\n" +
            "\n" +
            "eyr:2028 ecl:brn\n" +
            "hcl:#efcc98\n" +
            "hgt:157cm\n" +
            "iyr:2012\n" +
            "pid:212547203 byr:1970\n" +
            "\n" +
            "eyr:2029 pid:182693366 hcl:#623a2f hgt:130 byr:1972\n" +
            "cid:310\n" +
            "iyr:2010 ecl:amb\n" +
            "\n" +
            "byr:1944 iyr:2013\n" +
            "ecl:brn cid:335\n" +
            "hgt:163cm\n" +
            "eyr:2025 hcl:#7d3b0c pid:405230824\n" +
            "\n" +
            "hcl:#ceb3a1 iyr:2015 pid:572001387 byr:1962\n" +
            "ecl:amb hgt:151cm\n" +
            "\n" +
            "byr:1928\n" +
            "eyr:2022\n" +
            "iyr:2018 ecl:blu\n" +
            "hcl:#602927 pid:767081131\n" +
            "\n" +
            "byr:1948 hgt:180in pid:188cm\n" +
            "ecl:hzl\n" +
            "eyr:2013 hcl:e0b9f3 iyr:1975\n" +
            "\n" +
            "hcl:#c0946f byr:1989\n" +
            "eyr:1980 hgt:67cm pid:538025041\n" +
            "iyr:2014 ecl:gry\n" +
            "\n" +
            "eyr:2028 pid:958756919 hcl:#733820 byr:1945 cid:158 ecl:blu\n" +
            "hgt:168cm iyr:2018\n" +
            "\n" +
            "cid:200 hcl:#fffffd\n" +
            "byr:2015 ecl:gry eyr:2031 hgt:59 pid:065027646\n" +
            "iyr:1967\n" +
            "\n" +
            "byr:1999 ecl:hzl pid:813536928 iyr:2015 cid:296 hcl:#6b5442\n" +
            "eyr:2025 hgt:186cm\n" +
            "\n" +
            "byr:2000 iyr:2012\n" +
            "hcl:#fffffd\n" +
            "cid:263 hgt:68in pid:105489529\n" +
            "ecl:amb eyr:2024\n" +
            "\n" +
            "eyr:2026 hcl:#602927 hgt:181cm\n" +
            "byr:1982\n" +
            "pid:603871531 iyr:2018 ecl:blu\n" +
            "\n" +
            "cid:302 pid:387895477 eyr:2027\n" +
            "hcl:#cfa07d hgt:191cm iyr:2015\n" +
            "ecl:hzl byr:1940\n" +
            "\n" +
            "iyr:2018 cid:165\n" +
            "ecl:blu hgt:181cm byr:1994 eyr:2026 pid:077013268\n" +
            "\n" +
            "eyr:2022 hgt:174in iyr:2010 byr:2023\n" +
            "hcl:#733820 ecl:oth\n" +
            "pid:311692961\n" +
            "\n" +
            "ecl:#10f2a9 pid:964417986\n" +
            "eyr:2024 hcl:#0aeec7 byr:1965 iyr:1943 hgt:167cm\n" +
            "\n" +
            "hcl:#341e13 iyr:2020\n" +
            "ecl:brn\n" +
            "hgt:188cm eyr:2021 byr:1952\n" +
            "pid:077471062\n" +
            "\n" +
            "byr:1950 cid:110 hgt:160cm eyr:2026\n" +
            "hcl:#623a2f\n" +
            "iyr:2013\n" +
            "pid:972823574\n" +
            "\n" +
            "pid:553704996 hgt:171cm\n" +
            "eyr:2028 iyr:2017\n" +
            "hcl:#18171d byr:1954 ecl:blu\n" +
            "\n" +
            "hgt:180cm ecl:brn eyr:2029 pid:707999496 hcl:#cfa07d byr:1960\n" +
            "\n" +
            "pid:9325738036 iyr:1996 hgt:152in byr:2004 cid:292 hcl:14a56f\n" +
            "eyr:2031\n" +
            "ecl:#dbd99d\n" +
            "\n" +
            "byr:1957\n" +
            "eyr:2021 pid:557648216 ecl:amb hcl:#7d3b0c hgt:186cm\n" +
            "iyr:2020\n" +
            "\n" +
            "hcl:#602927 hgt:186cm pid:604175608\n" +
            "iyr:2013 eyr:2026 ecl:oth byr:1991 cid:65\n" +
            "\n" +
            "ecl:gry\n" +
            "iyr:2012 hgt:154cm\n" +
            "pid:872898058 eyr:2030 hcl:#341e13 byr:1994\n" +
            "\n" +
            "pid:228236326\n" +
            "iyr:2013 cid:347 byr:1942\n" +
            "eyr:2021 ecl:brn\n" +
            "hgt:165cm\n" +
            "hcl:#fffffd\n" +
            "\n" +
            "pid:392777182 cid:189 hcl:#cfa07d eyr:2027 hgt:191cm ecl:blu byr:1978\n" +
            "\n" +
            "hgt:158in iyr:2028\n" +
            "pid:5145408095 byr:2012 ecl:#94c57d hcl:z eyr:1996\n" +
            "\n" +
            "byr:1949 eyr:2021\n" +
            "ecl:#5ffbeb iyr:1948 pid:42650064 hcl:z hgt:167cm\n" +
            "\n" +
            "iyr:2013 ecl:xry cid:100\n" +
            "hgt:138 byr:2013\n" +
            "eyr:1944 hcl:92b68c\n" +
            "\n" +
            "hgt:187cm\n" +
            "ecl:grn hcl:#602927\n" +
            "iyr:2010\n" +
            "eyr:2022 byr:1949 cid:280 pid:251802347\n" +
            "\n" +
            "ecl:grn\n" +
            "cid:219\n" +
            "iyr:2018 hgt:165cm\n" +
            "pid:703878503 eyr:2024 hcl:#b6652a\n" +
            "byr:2002\n" +
            "\n" +
            "hcl:#18171d cid:341 ecl:amb byr:1941 eyr:2021 iyr:1990 pid:865132177 hgt:153cm\n" +
            "\n" +
            "byr:2008 pid:861480549\n" +
            "cid:97 eyr:2028 hcl:#efcc98\n" +
            "iyr:2015\n" +
            "hgt:191cm ecl:#232b23\n" +
            "\n" +
            "hcl:#cfa07d\n" +
            "eyr:2030 iyr:2013 cid:304\n" +
            "ecl:gry pid:199056608 hgt:192cm\n" +
            "byr:1926\n" +
            "\n" +
            "pid:355135528 hgt:153cm byr:1998 iyr:2019 eyr:2027\n" +
            "ecl:amb hcl:#18171d\n" +
            "\n" +
            "eyr:2028 hcl:8eed9c ecl:grn\n" +
            "iyr:2010 byr:2005 hgt:107\n" +
            "pid:64892698\n" +
            "\n" +
            "pid:601671623 hgt:153cm iyr:2011 hcl:#b6652a byr:1975 ecl:grn eyr:2029\n" +
            "\n" +
            "ecl:grn hcl:#18171d hgt:157cm\n" +
            "eyr:2023 pid:507932715 byr:1920 iyr:2020\n" +
            "\n" +
            "eyr:2022 byr:1933 hcl:#fffffd iyr:2016 hgt:181cm pid:826522507 ecl:blu\n" +
            "\n" +
            "byr:2002 hcl:#866857 hgt:177cm pid:240202426\n" +
            "ecl:gry cid:127\n" +
            "eyr:2022\n" +
            "iyr:2014\n" +
            "\n" +
            "byr:1971\n" +
            "iyr:2017\n" +
            "pid:733985576 hcl:#c58c6c hgt:178cm\n" +
            "ecl:blu\n" +
            "eyr:2023\n" +
            "\n" +
            "ecl:blu iyr:2017 pid:558732458 hcl:#1b3ab5 eyr:2025 byr:1967 hgt:176cm\n" +
            "\n" +
            "eyr:2025 ecl:gry iyr:2020 byr:1988\n" +
            "hcl:#733820\n" +
            "hgt:189cm cid:151 pid:934827751\n" +
            "\n" +
            "ecl:gry eyr:1951\n" +
            "iyr:1932\n" +
            "pid:309366394 byr:1945 hcl:#623a2f hgt:179cm\n" +
            "\n" +
            "pid:462345884 ecl:hzl\n" +
            "cid:206 eyr:2021 hcl:#733820\n" +
            "byr:1982 hgt:180cm iyr:2010\n" +
            "\n" +
            "iyr:2020 hgt:155cm hcl:#341e13 pid:110467532 cid:92 ecl:hzl byr:1975 eyr:2028\n" +
            "\n" +
            "hcl:#18171d iyr:2010\n" +
            "hgt:182cm byr:1930\n" +
            "eyr:2024\n" +
            "cid:226\n" +
            "\n" +
            "byr:1956 hcl:fb0c6f pid:181cm eyr:2012 iyr:2020\n" +
            "ecl:#d38822\n" +
            "hgt:69cm\n" +
            "\n" +
            "ecl:gry iyr:2018\n" +
            "hgt:169cm byr:1981\n" +
            "pid:534824014 cid:287 eyr:2021 hcl:#c0946f\n" +
            "\n" +
            "eyr:2039 hcl:#328e90 iyr:2015\n" +
            "hgt:170cm pid:#9fa2a4 byr:1999\n" +
            "ecl:#cd1fd7\n" +
            "\n" +
            "hgt:190cm hcl:#733820\n" +
            "pid:302244363\n" +
            "ecl:brn\n" +
            "byr:1965 iyr:2013\n" +
            "\n" +
            "iyr:2012\n" +
            "eyr:2021\n" +
            "pid:579705743\n" +
            "ecl:brn hgt:190in\n" +
            "byr:1954 hcl:#888785\n" +
            "\n" +
            "eyr:2036 hgt:154cm\n" +
            "pid:800720865 byr:2023 ecl:oth iyr:2010 hcl:z\n" +
            "\n" +
            "pid:#92f6a9 iyr:2028 eyr:1943\n" +
            "hgt:191cm ecl:hzl hcl:z byr:2018\n" +
            "\n" +
            "hcl:#c0946f\n" +
            "pid:419930442 hgt:167cm\n" +
            "byr:1969\n" +
            "eyr:2020 ecl:brn\n" +
            "\n" +
            "pid:137802946\n" +
            "eyr:2020 byr:1947 ecl:grn hgt:192cm iyr:2016 hcl:#888785\n" +
            "\n" +
            "ecl:#f66cce eyr:1958 iyr:1954\n" +
            "pid:833131572\n" +
            "hcl:z\n" +
            "cid:212\n" +
            "hgt:109 byr:1924\n" +
            "\n" +
            "hgt:179cm ecl:gry pid:065881341 byr:1985\n" +
            "hcl:#fffffd cid:204 eyr:2026\n" +
            "\n" +
            "hgt:167cm\n" +
            "iyr:2017 pid:898571403 byr:1929\n" +
            "ecl:blu hcl:#d506d0 eyr:2028 cid:100\n" +
            "\n" +
            "byr:1991 pid:2795214253 iyr:2011\n" +
            "cid:152 eyr:2028\n" +
            "hgt:170cm hcl:#a45065 ecl:lzr\n" +
            "\n" +
            "hgt:188cm eyr:2030 iyr:2010\n" +
            "pid:297292695 byr:1955 hcl:#fffffd\n" +
            "ecl:blu\n" +
            "\n" +
            "hgt:170cm eyr:2029 pid:913242036 byr:1993 cid:89 hcl:#888785\n" +
            "iyr:2010\n" +
            "ecl:blu\n" +
            "\n" +
            "iyr:2028 eyr:2025 hgt:150in ecl:grn\n" +
            "byr:1995\n" +
            "pid:974802728\n" +
            "hcl:#cfa07d\n" +
            "\n" +
            "eyr:2021 byr:1989\n" +
            "hcl:#18171d ecl:blu hgt:168cm\n" +
            "pid:626530259\n" +
            "iyr:2020\n" +
            "\n" +
            "hcl:#6b5442 hgt:158cm pid:798732187 byr:1922 eyr:2020 iyr:2011 ecl:gry\n" +
            "\n" +
            "hcl:#341e13 pid:092679330 byr:1997 ecl:oth hgt:159cm iyr:2010 eyr:2026\n" +
            "\n" +
            "hgt:185cm\n" +
            "iyr:2020 byr:1947\n" +
            "pid:105846744 ecl:gry cid:134 eyr:2027\n" +
            "\n" +
            "pid:252016128 hcl:9016ff cid:158 hgt:161 ecl:gry\n" +
            "byr:1952 eyr:1955 iyr:2018\n" +
            "\n" +
            "iyr:2020 hgt:154in byr:1958\n" +
            "eyr:2029 ecl:#2feb89 pid:99780178\n" +
            "\n" +
            "hcl:z\n" +
            "eyr:2001 ecl:gmt\n" +
            "byr:2022 hgt:73in iyr:2029\n" +
            "pid:388744230\n" +
            "\n" +
            "hgt:186cm\n" +
            "byr:1939 pid:622948608 ecl:oth eyr:2030\n" +
            "hcl:#c0946f\n" +
            "\n" +
            "cid:272\n" +
            "eyr:2025 byr:1979 ecl:brn hgt:180cm pid:456545466\n" +
            "hcl:#fffffd iyr:2012\n" +
            "\n" +
            "pid:946657041 byr:1999\n" +
            "iyr:2014 hcl:#ceb3a1 hgt:150cm\n" +
            "ecl:grn\n" +
            "\n" +
            "byr:1957 pid:177cm ecl:blu eyr:2020 hcl:#cfa07d\n" +
            "iyr:2010 hgt:183cm\n" +
            "\n" +
            "pid:161cm eyr:2025 hcl:#b6652a\n" +
            "cid:213\n" +
            "ecl:xry\n" +
            "hgt:150cm\n" +
            "iyr:2024 byr:2012\n" +
            "\n" +
            "hcl:ea1960\n" +
            "ecl:grn\n" +
            "pid:#7127b2 iyr:2012 eyr:2011 hgt:150\n" +
            "\n" +
            "pid:178699291\n" +
            "hgt:66in eyr:2027\n" +
            "byr:1985 iyr:2014 ecl:amb\n" +
            "\n" +
            "iyr:2017 ecl:blu\n" +
            "eyr:2027 hgt:191cm byr:1990 hcl:#b6652a pid:074411798\n" +
            "\n" +
            "pid:528782860\n" +
            "hgt:181cm hcl:#c0946f byr:1965 iyr:2012 ecl:grn eyr:2020\n" +
            "\n" +
            "pid:#ba10da hgt:176in byr:2006\n" +
            "ecl:grt\n" +
            "iyr:2030 eyr:1949 hcl:d3ca76\n" +
            "\n" +
            "hgt:66cm ecl:#898478 hcl:#e9f7a5 eyr:2030 iyr:2022\n" +
            "byr:2025\n" +
            "pid:159cm\n" +
            "\n" +
            "byr:1994 hcl:#ceb3a1\n" +
            "pid:028071950 eyr:2022 ecl:gmt hgt:151in iyr:2016\n" +
            "\n" +
            "byr:2001 iyr:2011\n" +
            "ecl:brn\n" +
            "pid:487702556 hcl:#602927\n" +
            "hgt:167cm eyr:2026";

    public long getNumberOfValidPassports() {
        return getNumberOfValidPassports(inputData);
    }

    public long getNumberOfValidPassports(String data) {
        String[] chunks = data.split("\n\n");
        long validPassports = 0;
        validPassports = Arrays.stream(chunks).filter(s -> isCorrectlyFormatted(s)).count();
        return validPassports;
    }

    private boolean isCorrectlyFormatted(String passport) {
        if (!passport.contains("byr") || !passport.contains("iyr") || !passport.contains("eyr") || !passport.contains("hgt")
                || !passport.contains("hcl") || !passport.contains("ecl") || !passport.contains("pid")) {
            return false;
        }
        List<String> categories = new LinkedList<>();
        String[] lines = passport.split("\n");
        for (String line : lines) {
            Collections.addAll(categories, line.split(" "));
        }

        for (String category : categories) {
            if (!isValidCategory(category)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCategory(String category) {
        String content = category.substring(4);
        return switch (category.substring(0, 3)) {
            case "byr" -> validateByr(content);
            case "iyr" -> validateIyr(content);
            case "eyr" -> validateEyr(content);
            case "hgt" -> validateHgt(content);
            case "hcl" -> validateHcl(content);
            case "ecl" -> validateEcl(content);
            case "pid" -> validatePid(content);
            default -> true;
        };
    }

    private boolean validateByr(String content) {
        return isNumberBetween(content, 1920, 2002);
    }

    private boolean validateIyr(String content) {
        return isNumberBetween(content, 2010, 2020);
    }

    private boolean validateEyr(String content) {
        return isNumberBetween(content, 2020, 2030);
    }

    private boolean validateHgt(String content) {
        if (content.contains("cm")) {
            return isNumberBetween(content.substring(0, content.indexOf("cm")), 150, 193);
        } else if (content.contains("in")) {
            return isNumberBetween(content.substring(0, content.indexOf("in")), 59, 76);
        } else return false;
    }

    private boolean validateHcl(String content) {
        if (content.length() != 7 && content.charAt(0) != '#') {
            return false;
        }
        for (int i = 1; i < content.length(); i++) {
            if (!(Character.isDigit(content.charAt(i)) || (content.charAt(i) >= 'a' && content.charAt(i) <= 'f'))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateEcl(String content) {
        return content.equals("amb") || content.equals("blu") || content.equals("brn") || content.equals("gry")
                || content.equals("grn") || content.equals("hzl") || content.equals("oth");
    }

    private boolean validatePid(String content) {
        if (content.length() != 9) {
            return false;
        }
        for (int i = 0; i < content.length(); i++) {
            if (!Character.isDigit(content.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumberBetween(String content, int min, int max) {
        try {
            int year = Integer.parseInt(content);
            return min <= year && year <= max;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

}
