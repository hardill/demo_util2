package com.test.lambda;

import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
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

}