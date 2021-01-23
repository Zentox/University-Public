Lunch lunch = s -> {
	if (s.startsWith("bread") && s.endsWith("bread")) {
		return s.substring(5, s.length() - 5);
	}
	throw new NoBreadException(s);
};