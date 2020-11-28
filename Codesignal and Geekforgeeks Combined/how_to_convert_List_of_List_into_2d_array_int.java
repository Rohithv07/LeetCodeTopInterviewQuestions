List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    helperFunction(result, current, n, 0);
    int [][] array = new int [result.size()][];
    for (int i=0; i<array.length; i++) {
        array[i] = new int [result.get(i).size()];
    }
    for (int i=0; i<array.length; i++) {
        for (int j=0; j<result.get(i).size(); j++) {
            array[i][j] = result.get(i).get(j);
        }
    }
    return array;
}
