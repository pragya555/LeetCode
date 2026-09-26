class Solution{

public static String evaluate(
	String str,
	List<List<String>> mapList
){
	var keyToValue = new HashMap<String, String>();
	for (List<String> map : mapList){
		keyToValue.put(map.get(0), map.get(1));
	}

	var strBuilder = new StringBuilder();
	for (String subStr : str.split("\\)")){
		int leftBracketIdx = subStr.indexOf("(");
		if (leftBracketIdx == -1){
			leftBracketIdx = subStr.length();
		}

		strBuilder.append(subStr.substring(0, leftBracketIdx));
		if (leftBracketIdx != subStr.length()){
			strBuilder.append(
				keyToValue.getOrDefault(
					subStr.substring(leftBracketIdx + 1, subStr.length()),
					"?"
				)
			);
		}
	}
	return strBuilder.toString();
}

}