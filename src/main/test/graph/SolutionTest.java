package graph;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import graph.UniquePaths;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {
	@Test
	public void uniquePaths() {
		UniquePaths solution = new UniquePaths();
		assertThat(solution.uniquePaths(2,2), CoreMatchers.is(2));
		assertThat(solution.uniquePaths(100,1), CoreMatchers.is(1));
		assertThat(solution.uniquePaths(1,100), CoreMatchers.is(1));
		assertThat(solution.uniquePaths(15,9), CoreMatchers.is(319770));


	}
}
