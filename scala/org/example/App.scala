import scala.collection.mutable.ListBuffer
object app {
  def main(args: Array[String]): Unit = {
    //3a
    var Str="Hello, Scala!"
    //выводит фразу «Hello, Scala!» справа налево
    //println(Str.foldLeft(List[Char]()){(x,y)=>y::x}.mkString(""))
    println(Str.reverse)
    //переводит всю фразу в нижний регистр
    println(Str.toLowerCase)
    // удаляет символ!
    println(Str.replace("!",""))
    //добавляет в конец фразы «and goodbye python!»
    println(Str.replace("!","")+ " and goodbye python!")

    //3b
    val sumTotal:Double = 880
    println(f"\nЗначение годового дохода: $sumTotal%.0f")
    val bonus:Double = 56 //%
    println(f"размер премии в процентах от годового дохода: $bonus%.0f %%")
    val sumFoodAllowance: Double = 26.4
    println(f"компенсация питания: $sumFoodAllowance")

    var salary:Double = (sumTotal * (1 - (bonus / 100)) / 12 - sumFoodAllowance) * 0.87
    salary="%.3f".format(salary).replace(",",".").toDouble //округляю до 3 знаков, не придумал как проще
    println(s"Оклад за вычетом ПДН = $salary")

    //3c
    var Employees = ListBuffer[Double](100,150,200,80,120,75)
    Employees+=salary

    var mid: Double = Employees.sum / Employees.size
    println(f"\nОтклонение от среднего значение оклада (от $mid%.2f):")
    var delta= for (elem <- Employees) yield 100*(elem- mid) / mid
    for (value<- delta)  println(f"$value%.2f %%")

    //3d
    Employees(2)=mid //отнимаю все что выше среднего у второго сторудника
    Employees(6)+=mid*delta(2)/100 // добавляю шестому
    //for (value<- Employees)  println(f"$value%.3f")
    println()
    println(f"Самая высокая зарплата =  ${Employees.max}%.3f")
    println(f"Самая низкая зарплата =  ${Employees.min}%.3f")

    //3e
    Employees+=350
    Employees+=90
    Employees=Employees.sorted
    println()
    for (value<- Employees)  println(f"$value%.3f")

    //3f
    println()
    val newSalary:Double=130
    var i=0
    while ((i<=Employees.length-1)&&(Employees(i)<newSalary)){
      i=i+1
    }
    Employees = {Employees.take(i):+newSalary}++Employees.drop(i)
    for (value<- Employees)  println(f"$value%.3f")

    //3g
    var middleSalMin = 90
    var middleSalMax = 130
    println("индексы сотрудников уровня middle: ")
    for (i <- 0 until Employees.size) if ((Employees(i) <= middleSalMax)&&(Employees(i) >= middleSalMin)) print(f"$i ")

    //3h
    println()
    println("Проиндексированные на 7% оклады:")
    Employees = Employees.map(value=>value*1.07)
    for (value<- Employees)  println(f"$value%.3f")
  }
}
