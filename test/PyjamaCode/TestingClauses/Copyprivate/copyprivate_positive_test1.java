package PyjamaCode.TestingClauses.Copyprivate;

import pj.Pyjama;

public class copyprivate_positive_test1 {

	public int[] parallel_copyPrivate(int threadNumber) {
		Pyjama.omp_set_num_threads(threadNumber);
		int i = threadNumber;
		int[] array = new int[threadNumber];

		//#omp parallel
		{
			//#omp single copyprivate(i) 
			{
				int index = Pyjama.omp_get_thread_num();
				array[index] = i++;
			}
		}

		return array;
	}

}
