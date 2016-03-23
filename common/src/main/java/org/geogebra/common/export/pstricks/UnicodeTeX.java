package org.geogebra.common.export.pstricks;

import java.util.HashMap;

import org.geogebra.common.util.Unicode;

public class UnicodeTeX {

	private static HashMap<String, String> unicode2tex = null;

	private static void p(char unicode, String tex) {
		unicode2tex.put(unicode + "", tex);
	}

	public static HashMap<String, String> getMap() {
		if (unicode2tex != null) {
			return unicode2tex;
		}
		unicode2tex = new HashMap<String, String>();
		p('\u00a3', "sterling");
		p('\u00a5', "yen");
		p('\u00a9', "copyright");
		p('\u00ab', "ll");
		p('\u00ac', "neg");
		p('\u00ae', "circledR");
		p('\u00b1', "pm");
		p('\u00b4', "textasciiacute");
		p(Unicode.micro, "mu");
		p('\u00b7', "cdotp");
		p('\u00bb', "gg");
		p('\u00bc', "frac 14");
		p('\u00bd', "frac 12");
		p('\u00be', "frac 34");
		p('\u00bf', "textquestiondown");
		p('\u00c6', "AE");
		p('\u00d7', "times");
		p('\u00df', "ss");
		p('\u00e6', "ae");
		p('\u00f0', "eth");
		p('\u00f7', "div");
		p('\u019b', "lambdabar");
		p('\u02bc', "rasp");
		p('\u02bd', "lasp");
		p('\u0300', "grave");
		p('\u0301', "acute");
		p('\u0302', "hat");
		p('\u0303', "tilde");
		p('\u0304', "bar");
		p('\u0306', "breve");
		p('\u0307', "dot");
		p('\u0308', "ddot");
		p('\u030a', "ocirc");
		p('\u030c', "check");
		p('\u0331', "underbar");
		p('\u0338', "not");
		p('\u0360', "widehat");
		p('\u0393', "Gamma");
		p('\u0394', "Delta");
		p('\u0398', "Theta");
		p('\u039b', "Lambda");
		p('\u039e', "Xi");
		p('\u03a0', "Pi");
		p('\u03a3', "Sigma");
		p('\u03a6', "Phi");
		p('\u03a8', "Psi");
		p('\u03a9', "Omega");
		p('\u03b1', "alpha");
		p('\u03b2', "beta");
		p('\u03b3', "gamma");
		p('\u03b4', "delta");
		p('\u03b5', "varepsilon");
		p('\u03b6', "zeta");
		p('\u03b7', "eta");
		p('\u03b8', "theta");
		p('\u03b9', "iota");
		p('\u03ba', "kappa");
		p('\u03bb', "lambda");
		p('\u03bc', "mu");
		p('\u03bd', "nu");
		p('\u03be', "xi");
		p(Unicode.pi, "pi");
		p('\u03c1', "rho");
		p('\u03c2', "varsigma");
		p('\u03c3', "sigma");
		p('\u03c4', "tau");
		p('\u03c5', "upsilon");
		p('\u03c6', "phi");
		p('\u03c7', "chi");
		p('\u03c8', "psi");
		p('\u03c9', "omega");
		p('\u03d2', "Upsilon");
		p('\u03d5', "varphi");
		p('\u03d6', "varpi");
		p('\u03f0', "varkappa");
		p('\u03f1', "varrho");
		p('\u2002', "enspace");
		p('\u2003', "quad");
		p('\u2005', "thickspace");
		p('\u2009', "thinspace");
		p('\u200a', "hspace");
		p('\u2013', "endash");
		p('\u2014', "emdash");
		p('\u2016', "Vert");
		p('\u2018', "lq");
		p('\u2019', "rq");
		p('\u201c', "textquotedblleft");
		p('\u201d', "textquotedblright");
		p('\u2020', "dagger");
		p('\u2020', "dagger");
		p('\u2021', "ddagger");
		p('\u2021', "ddagger");
		p('\u2026', "dots");
		p('\u2032', "prime");
		p('\u2035', "backprime");
		p('\u20d6', "overleftarrow");
		p('\u20d7', "vec");
		p('\u20db', "dddot");
		p('\u20dc', "ddddot");
		p('\u20e1', "overleftrightarrow");
		p('\u210f', "hslash");
		p('\u2111', "Im");
		p('\u2113', "ell");
		p('\u2116', "textnumero");
		p('\u2118', "wp");
		p('\u211c', "Re");
		p('\u2127', "mho");
		p('\u212b', "AA");
		p('\u2132', "Finv");
		p('\u2135', "aleph");
		p('\u2136', "beth");
		p('\u2137', "gimel");
		p('\u2138', "daleth");
		p('\u2190', "leftarrow");
		p('\u2191', "uparrow");
		p('\u2192', "rightarrow");
		p('\u2193', "downarrow");
		p('\u2194', "leftrightarrow");
		p('\u2195', "updownarrow");
		p('\u2196', "nwarrow");
		p('\u2197', "nearrow");
		p('\u2198', "searrow");
		p('\u2199', "swarrow");
		p('\u219a', "nleftarrow");
		p('\u219b', "nrightarrow");
		p('\u219c', "leftsquigarrow");
		p('\u219d', "rightsquigarrow");
		p('\u219e', "twoheadleftarrow");
		p('\u21a0', "twoheadrightarrow");
		p('\u21a2', "leftarrowtail");
		p('\u21a3', "rightarrowtail");
		p('\u21a4', "mapsfrom");
		p('\u21a6', "mapsto");
		p('\u21a9', "hookleftarrow");
		p('\u21aa', "hookrightarrow");
		p('\u21ab', "looparrowleft");
		p('\u21ac', "looparrowright");
		p('\u21ad', "leftrightsquigarrow");
		p('\u21ae', "nleftrightarrow");
		p('\u21b0', "Lsh");
		p('\u21b1', "Rsh");
		p('\u21b6', "curvearrowleft");
		p('\u21b7', "curvearrowright");
		p('\u21bc', "leftharpoonup");
		p('\u21bd', "leftharpoondown");
		p('\u21be', "upharpoonleft");
		p('\u21bf', "upharpoonright");
		p('\u21c0', "rightharpoonup");
		p('\u21c1', "rightharpoondown");
		p('\u21c2', "downharpoonright");
		p('\u21c3', "downharpoonleft");
		p('\u21c4', "rightleftarrows");
		p('\u21c6', "leftrightarrows");
		p('\u21c7', "leftleftarrows");
		p('\u21c8', "upuparrows");
		p('\u21c9', "rightrightarrows");
		p('\u21ca', "downdownarrows");
		p('\u21cb', "leftrightharpoons");
		p('\u21cc', "rightleftharpoons");
		p('\u21cd', "nLeftarrow");
		p('\u21ce', "nleftrightarrow");
		p('\u21cf', "nRightarrow");
		p('\u21d0', "Leftarrow");
		p('\u21d1', "Uparrow");
		p('\u21d2', "Rightarrow");
		p('\u21d3', "Downarrow");
		p('\u21d4', "Leftrightarrow");
		p('\u21d5', "Updownarrow");
		p('\u21da', "Lleftarrow");
		p('\u21db', "Rrightarrow");
		p('\u2200', "forall");
		p('\u2201', "complement");
		p('\u2202', "partial");
		p('\u2203', "exists");
		p('\u2204', "nexists");
		p('\u2205', "varnothing");
		p('\u2206', "triangle");
		p('\u2207', "nabla");
		p(Unicode.IS_ELEMENT_OF, "in");
		p('\u2209', "notin");
		p('\u220a', "in");
		p('\u220b', "ni");
		p('\u220f', "prod");
		p('\u2210', "coprod");
		p('\u2211', "sum");
		p('\u2212', "minus");
		p('\u2213', "mp");
		p('\u2214', "dotplus");
		p('\u2215', "slash");
		p('\u2216', "setminus");
		p('\u2217', "ast");
		p('\u2218', "circ");
		p('\u2219', "bullet");
		p('\u221a', "surd");
		p('\u221d', "propto");
		p('\u221e', "infty");
		p('\u2220', "angle");
		p('\u2221', "measuredangle");
		p('\u2222', "sphericalangle");
		p('\u2223', "mid");
		p('\u2224', "nmid");
		p('\u2225', "parallel");
		p('\u2226', "nparallel");
		p('\u2227', "wedge");
		p('\u2228', "vee");
		p('\u2229', "cap");
		p('\u222a', "cup");
		p('\u222b', "int");
		p('\u222c', "iint");
		p('\u222d', "iiint");
		p('\u222e', "oint");
		p('\u2234', "therefore");
		p('\u2235', "because");
		p('\u2237', "Colon");
		p('\u2238', "dotminus");
		p('\u223b', "kernelcontraction");
		p('\u223c', "sim");
		p('\u223d', "backsim");
		p('\u2240', "wr");
		p('\u2241', "nsim");
		p('\u2242', "eqsim");
		p('\u2243', "simeq");
		p('\u2244', "nsime");
		p('\u2245', "cong");
		p('\u2247', "ncong");
		p('\u2248', "approx");
		p('\u2249', "napprox");
		p('\u224a', "approxeq");
		p('\u224d', "asymp");
		p('\u224e', "Bumpeq");
		p('\u224f', "bumpeq");
		p('\u2250', "doteq");
		p('\u2251', "Doteq");
		p('\u2252', "fallingdotseq");
		p('\u2253', "risingdotseq");
		p('\u2254', "coloneq");
		p('\u2255', "eqcolon");
		p('\u2256', "eqcirc");
		p('\u2257', "circeq");
		p('\u2259', "wedgeq");
		p('\u225c', "triangleq");
		p('\u225f', "questeq");
		p('\u2260', "ne");
		p('\u2261', "equiv");
		p('\u2262', "nequiv");
		p('\u2264', "le");
		p('\u2265', "ge");
		p('\u2266', "leqq");
		p('\u2267', "geqq");
		p('\u2268', "lneqq");
		p('\u2269', "gneqq");
		p('\u226a', "ll");
		p('\u226b', "gg");
		p('\u226c', "between");
		p('\u226e', "nless");
		p('\u226f', "ngtr");
		p('\u2270', "nleqslant");
		p('\u2271', "ngeqslant");
		p('\u2272', "lesssim");
		p('\u2273', "gtrsim");
		p('\u2276', "lessgtr");
		p('\u2277', "gtrless");
		p('\u227a', "prec");
		p('\u227b', "succ");
		p('\u227c', "preccurlyeq");
		p('\u227d', "succcurlyeq");
		p('\u227e', "precsim");
		p('\u227f', "succsim");
		p('\u2280', "nprec");
		p('\u2281', "nsucc");
		p(Unicode.IS_SUBSET_OF_STRICT, "subset");
		p('\u2283', "supset");
		p('\u2284', "nsubset");
		p('\u2285', "nsupset");
		p(Unicode.IS_SUBSET_OF, "subseteq");
		p('\u2287', "supseteq");
		p('\u2288', "nsubseteq");
		p('\u2289', "nsupseteq");
		p('\u228a', "subsetneq");
		p('\u228b', "supsetneq");
		p('\u228d', "cupdot");
		p('\u228e', "uplus");
		p('\u228f', "sqsubset");
		p('\u2290', "sqsupset");
		p('\u2291', "sqsubseteq");
		p('\u2292', "sqsupseteq");
		p('\u2293', "sqcap");
		p('\u2294', "sqcup");
		p('\u2295', "oplus");
		p('\u2296', "ominus");
		p('\u2297', "otimes");
		p('\u2298', "oslash");
		p('\u2299', "odot");
		p('\u229a', "circledcirc");
		p('\u229b', "circledast");
		p('\u229d', "circleddash");
		p('\u229e', "boxplus");
		p('\u229f', "boxminus");
		p('\u22a0', "boxtimes");
		p('\u22a1', "boxdot");
		p('\u22a2', "vdash");
		p('\u22a3', "dashv");
		p('\u22a4', "top");
		p(Unicode.PERPENDICULAR, "perp");
		p('\u22a7', "models");
		p('\u22a8', "vDash");
		p('\u22a9', "Vdash");
		p('\u22aa', "Vvdash");
		p('\u22ac', "nvdash");
		p('\u22ad', "nvDash");
		p('\u22ae', "nVdash");
		p('\u22af', "nVDash");
		p('\u22b2', "vartriangleleft");
		p('\u22b3', "vartriangleright");
		p('\u22b4', "trianglelefteq");
		p('\u22b5', "trianglerighteq");
		p('\u22b8', "multimap");
		p('\u22ba', "intercal");
		p('\u22bb', "veebar");
		p('\u22bc', "barwedge");
		p('\u22c0', "bigwedge");
		p('\u22c1', "bigvee");
		p('\u22c2', "bigcap");
		p('\u22c3', "bigcup");
		p('\u22c4', "diamond");
		p('\u22c5', "cdot");
		p('\u22c6', "star");
		p('\u22c7', "divideontimes");
		p('\u22c8', "bowtie");
		p('\u22c9', "ltimes");
		p('\u22ca', "rtimes");
		p('\u22cb', "leftthreetimes");
		p('\u22cc', "rightthreetimes");
		p('\u22cd', "backsimeq");
		p('\u22ce', "curlyvee");
		p('\u22cf', "curlywedge");
		p('\u22d0', "Subset");
		p('\u22d1', "Supset");
		p('\u22d2', "Cap");
		p('\u22d3', "Cup");
		p('\u22d4', "pitchfork");
		p('\u22d6', "lessdot");
		p('\u22d7', "gtrdot");
		p('\u22d9', "ggg");
		p('\u22da', "lesseqgtr");
		p('\u22db', "gtreqless");
		p('\u22de', "curlyeqprec");
		p('\u22df', "curlyeqsucc");
		p('\u2200', "lnsim");
		p('\u2200', "gnsim");
		p('\u22ea', "ntriangleleft");
		p('\u22eb', "ntriangleright");
		p('\u22ec', "ntrianglelefteq");
		p('\u22ed', "ntrianglerighteq");
		p('\u22ee', "vdots");
		p('\u22ef', "cdots");
		p('\u22f1', "ddots");
		p('\u2306', "doublebarwedge");
		p('\u2308', "lceil");
		p('\u2309', "rceil");
		p('\u230a', "lfloor");
		p('\u230b', "rfloor");
		p('\u231c', "ulcorner");
		p('\u231d', "urcorner");
		p('\u231e', "llcorner");
		p('\u231f', "lrcorner");
		p('\u2322', "frown");
		p('\u2323', "smile");
		p('\u2329', "langle");
		p('\u232a', "rangle");
		p('\u24c8', "circledS");
		p('\u25a0', "blacksquare");
		p('\u25a0', "blacksquare");
		p('\u25a1', "square");
		p('\u25a1', "square");
		p('\u25b3', "bigtriangleup");
		p('\u25b4', "blacktriangle");
		p('\u25b5', "vartriangle");
		p('\u25b8', "blacktriangleright");
		p('\u25b9', "triangleright");
		p('\u25bd', "bigtriangledown");
		p('\u25be', "blacktriangledown");
		p('\u25bf', "triangledown");
		p('\u25c2', "blacktriangleleft");
		p('\u25c3', "triangleleft");
		p('\u25ca', "lozenge");
		p('\u25cb', "bigcirc");
		p('\u2605', "bigstar");
		p('\u2660', "spadesuit");
		p('\u2661', "heartsuit");
		p('\u2662', "diamondsuit");
		p('\u2663', "clubsuit");
		p('\u266d', "flat");
		p('\u266e', "natural");
		p('\u266f', "sharp");
		p('\u2713', "checkmark");
		p('\u2720', "maltese");
		p('\ue200', "Longleftarrow");
		p('\ue201', "longleftarrow");
		p('\ue202', "Longleftrightarrow");
		p('\ue203', "longleftrightarrow");
		p('\ue204', "Longrightarrow");
		p('\ue205', "longrightarrow");
		p('\ue207', "dbkarow");
		p('\ue208', "longmapsto");
		p('\ue209', "drbkarrow");
		p('\ue20a', "hkswarow");
		p('\ue20b', "hksearow");
		p('\ue20e', "toea");
		p('\ue20f', "tosa");
		p('\ue241', "rightarrowtriangle");
		p('\ue242', "leftarrowtriangle");
		p('\ue243', "leftrightarrowtria");
		p('\ue251', "amalg");
		p('\ue254', "bigodot");
		p('\ue255', "bigoplus");
		p('\ue256', "bigotimes");
		p('\ue257', "bigsqcup");
		p('\ue258', "biguplus");
		p('\ue259', "intprod");
		p('\ue25a', "plusdot");
		p('\ue25b', "minusdot");
		p('\ue27f', "boxdiag");
		p('\ue280', "boxbslash");
		p('\ue293', "rmoustache");
		p('\ue294', "lmoustache");
		p('\ue29f', "gnapprox");
		p('\ue2a0', "gneq");
		p('\ue2a1', "gvertneqq");
		p('\ue2a2', "lnapprox");
		p('\ue2a3', "lneq");
		p('\ue2a4', "lvertneqq");
		p('\ue2a5', "ngeqq");
		p('\ue2a6', "ngeq");
		p('\ue2a7', "nleq");
		p('\ue2a8', "nleqq");
		p('\ue2aa', "nshortmid");
		p('\ue2ab', "nshortparallel");
		p('\ue2ae', "nsubseteqq");
		p('\ue2b0', "nsupseteqq");
		p('\ue2b2', "precnapprox");
		p('\ue2b3', "precneqq");
		p('\ue2b4', "succnapprox");
		p('\ue2b5', "succneqq");
		p('\ue2b6', "subsetneqq");
		p('\ue2b7', "supsetneqq");
		p('\ue2b8', "varsubsetneqq");
		p('\ue2b9', "varsubsetneq");
		p('\ue2ba', "varsupsetneq");
		p('\ue2bb', "varsupsetneqq");
		p('\ue2d4', "jmath");
		p('\ue2d5', "hbar");
		p('\ue2f4', "gtrapprox");
		p('\ue2f5', "gtreqqless");
		p('\ue2f6', "geqslant");
		p('\ue2f8', "lessapprox");
		p('\ue2f9', "lesseqqgtr");
		p('\ue2fa', "leqslant");
		p('\ue2fd', "precapprox");
		p('\ue2fe', "preceq");
		p('\ue2ff', "succapprox");
		p('\ue300', "succeq");
		p('\ue301', "shortmid");
		p('\ue302', "shortparallel");
		p('\ue303', "smallsmile");
		p('\ue304', "subseteqq");
		p('\ue305', "supseteqq");
		p('\ue306', "thickapprox");
		p('\ue309', "ddotseq");
		p('\ue30a', "mlcp");
		p('\ue316', "bumpeqq");
		p('\ue360', "digamma");
		p('\ue363', "bot");
		p('\ue365', "iff");
		p('\ue378', "iiiint");
		p('\ue396', "intbar");
		p('\ue5a3', "circlearrowleft");
		p('\ue5a4', "circlearrowright");
		p('\ue5c5', "disjquant");
		p('\ue5c6', "conjquant");
		p('\ue5cf', "eqslantless");
		p('\ue5dc', "npreceq");
		p('\ue5df', "eqslantgtr");
		p('\ue5f1', "nsucceq");
		p('\ue60c', "backcong");
		p('\ue616', "nBumpeq");
		p('\ue623', "emptyset");
		p('\ue629', "epsilon");
		p('\ue64e', "imath");
		p('\ue65b', "bigsqcap");
		p('\ue662', "thicksim");
		p('\ue800', "backepsilon");
		p('\ue801', "BbbPi");
		p('\ue802', "Bbbk");
		p('\ue803', "bbone");
		p('\ue804', "bbzero");
		p('\ue805', "bigcupdot");
		p('\ue809', "bigtimes");
		p('\ue80a', "bkarow");
		p('\ue80b', "blacklozenge");
		p('\ue80d', "boxast");
		p('\ue80e', "boxbar");
		p('\ue810', "boxcircle");
		p('\ue812', "btimes");
		p('\ue813', "dashV");
		p('\ue814', "Dashv");
		p('\ue816', "diagdown");
		p('\ue817', "diagup");
		p('\ue819', "dualmap");
		p('\ue81a', "forks");
		p('\ue81b', "forksnot");
		p('\ue81c', "Game");
		p('\ue821', "intBar");
		p('\ue822', "intcap");
		p('\ue823', "intcup");
		p('\ue824', "interleave");
		p('\ue825', "intx");
		p('\ue82d', "longmapsfrom");
		p('\ue82e', "Longmapsfrom");
		p('\ue830', "Longmapsto");
		p('\ue834', "Mapsfrom");
		p('\ue836', "nprecsim");
		p('\ue837', "nsuccsim");
		p('\ue838', "obar");
		p('\ue839', "obslash");
		p('\ue840', "partialmeetcontraction");
		p('\ue843', "smallfrown");
		p('\ue844', "smallsetminus");
		p('\ue846', "upand");
		p('\ue847', "varpropto");
		p('\ue848', "Vvert");
		p('\ue849', "widetilde");
		p('\ue84b', "clubsuitopen");
		p('\ue84c', "spadesuitopen");
		p('\ue84d', "nbumpeq");
		p('\ue84e', "neqsim");
		return unicode2tex;
	}
}