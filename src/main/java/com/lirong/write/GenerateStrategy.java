package com.lirong.write;

/**
 * @author LiRong
 */
public class GenerateStrategy {

    private static String generatePath;

    private static String perMergeFile;

    public static String getPerMergeFile() {
        return perMergeFile;
    }

    public static void setPerMergeFile(String perMergeFile) {
        GenerateStrategy.perMergeFile = perMergeFile;
    }

    public static String getGeneratePath() {
        return generatePath;
    }

    public static void setGeneratePath(String generatePath) {
        GenerateStrategy.generatePath = generatePath;
    }

    public static String preMerge(Integer i){

        String prePath =perMergeFile;
        return prePath + i + ".txt";
    }

    public static String generatePath(Integer i){

        String prePath =generatePath;
        return prePath + i + ".txt";
    }

}
