package ru.itis.kursach_data.Future;

import com.github.signaflo.math.polynomial.interpolation.NewtonPolynomial;

//Теперь Фичи проверяем тут (Насчёт прогнозов и тп)
public class FutureLogic {
    public static void main(String[] args) {
        double[][] mass = new double[][]{  // Сюда загрузку данных ввиде двойного массива года-значенич
                {2013, 747126},
                {2014, 733873},
                {2015, 709995},
                {2016, 649035},
                {2017,612045}
        };
        double[] pointmass = new double[]{2013,2016,2014,2017};           // Тестовый вариант (через интерполяцию ньютона) поиска недостающих значений
        double[] valuemass = new double[]{747126,649035,733873,612045};
        NewtonPolynomial np = new NewtonPolynomial(pointmass,valuemass);
        System.out.println(np.evaluateAt(2015));
    }
}
