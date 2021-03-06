package PyjamaCode.TestingDirectives.Sections;

public class section_negative_test1 {

	public int[] parallel_sections(int threadNumber) {
		Pyjama.omp_set_num_threads(threadNumber);
		int[] array = new int[threadNumber];

		int index=0;
		//#omp parallel 
		{
			index = Pyjama.omp_get_thread_num();
			//#omp sections
			{
				//#omp section
					index = Pyjama.omp_get_thread_num();
					array[index] = 1;

				//#omp section
					index = Pyjama.omp_get_thread_num();
					array[index] = 1;
			}		
		}
		return array;
	}

}
