class TimeMap {
    private class Datum {
        private String value;
        private int timestamp;

        public Datum(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Datum>> dataMap;

    public TimeMap() {
        this.dataMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!dataMap.containsKey(key)) {
            dataMap.put(key, new ArrayList<>());
        }

        dataMap.get(key).add(new Datum(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!dataMap.containsKey(key)) {
            return "";
        }

        // Search for the upper bound
        List<Datum> dataList = dataMap.get(key);
        int low = 0, high = dataList.size() - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            Datum midDatum = dataList.get(mid);
            if (midDatum.timestamp == timestamp) {
                return midDatum.value;
            }

            if (midDatum.timestamp > timestamp) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        // System.out.println("low = " + low);
        return low < dataList.size() && dataList.get(low).timestamp <= timestamp ? dataList.get(low).value : "";
    }
}
