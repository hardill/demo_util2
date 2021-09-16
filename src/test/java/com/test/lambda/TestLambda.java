package com.test.lambda;

import com.aliyun.opensearch.CloudsearchSearch;
import org.junit.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestLambda {

	@Test
	public void test9() throws Exception {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics statistics = primes.stream().mapToInt((x) -> x).summaryStatistics();
		long sum = statistics.getSum();
		int max = statistics.getMax();
		int min = statistics.getMin();

		System.err.printf("sum: %s,max: %s,min : %s%n", sum, max, min);

	}

	@Test
	public void test8() throws Exception {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> list = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.err.printf("numbes: %s,lsit: %s %n", numbers, list);
		System.err.println(list);

	}

	@Test
	public void test7() throws Exception {
		List<String> features = Arrays.asList("Lambdas", "Lam", "St", "Date");
		// 过滤长度大于3的集合成员,组成一个新集合list
		List<String> list = features.stream().filter(x -> x.length() > 3).collect(Collectors.toList());
		// 集合所以成员转大写,拼接成一个字符串,成员间用逗号隔开
		String collect = features.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
		System.err.println(collect);
		System.err.println(features);
		System.err.println(list);

	}

	@Test
	public void test6() throws Exception {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((c) -> c + .12 * c).reduce((sum, c) -> sum + c).get();
		System.err.println(bill);

	}

	@Test
	public void test5() throws Exception {
		Predicate<String> p1 = str -> str.startsWith("L");
		Predicate<String> p2 = str -> str.length() > 5;
		List<String> features = Arrays.asList("Lambdas", "Lam", "Stream API", "Date and Time API");
		features.stream().filter(p1.and(p2)).forEach(System.out::println);

	}

	@Test
	public void test4() throws Exception {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		filter(features, (str) -> str.startsWith("L"));
	}

	public static void filter(List<String> names, Predicate<String> condition) {
		names.forEach((s) -> {
			if (condition.test(s)) {
				System.out.println(s + " ");
			}
		});

		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

	@Test
	public void test3() throws Exception {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		// features.forEach(f -> System.err.println(f));
		features.forEach(System.err::println);
	}

	@Test
	public void test2() throws Exception {
		JButton show = new JButton("Show");
		show.addActionListener((e) -> {
			System.err.println("线程1启动" + e.toString());
		});
	}

	@Test
	public void test1() throws Exception {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.err.println("线程1启动");

			}
		}).start();

		new Thread(() -> System.err.println("线程2启动")).start();
	}

	@Test
	public void test21() {
		String filePath="";
		try(BufferedReader buff=new BufferedReader(new FileReader(filePath))){
			String line = buff.readLine();
			System.out.println(line);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void test22() {
		BigDecimal q = new BigDecimal("4");
		BigDecimal p = new BigDecimal("1733");
		System.out.println(q.multiply(p));

	}

	@Test
	public void test23() {
		"22213".contains("1");

		long timeLose = System.currentTimeMillis() +1000*60*5;
		Date date = new Date(timeLose);
		System.out.println(date);
		double a=0.122;
		double floor = Math.floor(a * 100)/100;
		System.out.println(floor);
		//Math.Floor(a*10)/10;

	}

	@Test
	public void test24() {
		CloudsearchSearch cloudsearchSearch = new CloudsearchSearch(null);
		cloudsearchSearch.addDistinct("ref_spu_id", 1, 1, "false");
		cloudsearchSearch.setPair("duniqfield:ref_spu_id");
		cloudsearchSearch.setFormulaName("products");
		cloudsearchSearch.setQueryString("");
		cloudsearchSearch.addFetchField("facet");
		cloudsearchSearch.setStartHit(1);

	}

	@Test
	public void test25() {
		String ip="66.249.68.41";
		String[] split = ip.split("\\.");
		int i = ip.lastIndexOf("\\.");
		System.out.println(i);
		boolean matches = ip.matches("66.249.*.*");
		System.out.println(matches);


	}

	@Test
	public void test26() {
		List<Date> list = new ArrayList<>();
		Date date1 = new Date(177777777777777l);
		Date date2 = new Date(177777777777778l);
		Date date3 = new Date(177777777779978l);
		list.add(date1);
		list.add(date2);
		list.add(date3);
		Optional<Date> max = list.stream().max(Comparator.comparing(d -> d));

		System.out.println(max.get().getTime());


	}

}
