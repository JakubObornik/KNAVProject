package exercises.exercise4.patterns.templatemethod;

import java.util.Arrays;
import java.util.List;

/** Mines data from documents of different formats through one fixed algorithm skeleton. */
public final class TemplateMethodDemo {

    private TemplateMethodDemo() {
    }

    public static void run() {
        List<DataMiner> miners = List.of(new DocDataMiner(), new CsvDataMiner(), new PdfDataMiner());
        for (DataMiner miner : miners) miner.mine("report");
    }

    private abstract static class DataMiner {

        /** Template method: the step order is fixed and cannot be overridden. */
        final void mine(String path) {
            String file = openFile(path);
            String rawData = extractData(file);
            List<String> data = parseData(rawData);
            List<String> analysis = analyzeData(data);
            hookBeforeReport();
            sendReport(analysis);
            closeFile(file);
        }

        // Abstract steps: every format must provide its own implementation.
        abstract String openFile(String path);
        abstract String extractData(String file);
        abstract void closeFile(String file);

        // Concrete steps: shared by all formats.
        List<String> parseData(String rawData) { return Arrays.stream(rawData.split(",")).map(String::trim).toList(); }
        List<String> analyzeData(List<String> data) { return data.stream().filter(value -> !value.isEmpty()).sorted().toList(); }
        void sendReport(List<String> analysis) { System.out.println("  Report: " + analysis); }

        // Hook: optional step with an empty default.
        void hookBeforeReport() {
        }
    }

    private static final class DocDataMiner extends DataMiner {
        String openFile(String path) { System.out.println("Opening " + path + ".doc"); return path + ".doc"; }
        String extractData(String file) { return "sales, costs, profit"; }
        void closeFile(String file) { System.out.println("  Closing " + file); }
    }

    private static final class CsvDataMiner extends DataMiner {
        String openFile(String path) { System.out.println("Opening " + path + ".csv"); return path + ".csv"; }
        String extractData(String file) { return "north,south,,east"; }
        void closeFile(String file) { System.out.println("  Closing " + file); }
        void hookBeforeReport() { System.out.println("  Hook: CSV header row validated"); }
    }

    private static final class PdfDataMiner extends DataMiner {
        String openFile(String path) { System.out.println("Opening " + path + ".pdf"); return path + ".pdf"; }
        String extractData(String file) { return "page 2, page 1"; }
        void closeFile(String file) { System.out.println("  Closing " + file); }
    }
}
