package com.demo.word;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 分词工具
 * */
public class WordEvaluation {
  private static SegmentationAlgorithm segmentationAlgorithm = SegmentationAlgorithm.values()[0];
  private static String bank =" ";

  public static List<String>segByWord(String text){
    if(StringUtils.isEmpty(text)){
      return null;
    }
    String seg = seg(text, segmentationAlgorithm);

    if(StringUtils.isEmpty(seg)||!seg.contains(bank)){
      return null;
    }
    return Arrays.asList(seg.split(bank));
  }

  public Map<String, String> segMore(String text) {
    Map<String, String> map = new HashMap<>();
    for (SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()) {
      map.put(segmentationAlgorithm.getDes(), seg(text, segmentationAlgorithm));
    }
    return map;
  }

  private static String seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
    StringBuilder result = new StringBuilder();
    WordSegmenter.segWithStopWords(text, segmentationAlgorithm)
        .stream()
        .forEach(word -> result.append(word.getText()).append(" "));
    return result.toString();
  }

  public static void main(String[] args) throws Exception {
    //WordEvaluation evaluation = new WordEvaluation();
    //Map<String, String> map = evaluation.segMore("我爱中国");
      String seg = seg("我爱中国", SegmentationAlgorithm.values()[0]);
      System.out.println(seg);
  }
}
