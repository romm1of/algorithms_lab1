package utils

import algorithm.quickSort
import algorithm.selectionSort
import pojo.Printer
import java.io.File
import java.time.LocalTime
import kotlin.system.measureNanoTime

object AppUtils {

    fun selectionSortTest() {
        val printers = loadValues()
        println(
            "Selection sort algorithm. \n " +
                    "Initial values: \n ${printers.contentToString()}"
        )
        val benchmarkTime = measureNanoTime {
            printers.selectionSort(Comparator.comparingInt(Printer::pagesPerMinute).reversed())
        }
        println("Result values: \n ${printers.contentToString()}")
        val resultTime = LocalTime.ofNanoOfDay(benchmarkTime)
        println("Result Time is $resultTime \n")
    }

    fun quickSortTest() {
        val printers = loadValues()
        println(
            "Quick sort algorithm. \n " +
                    "Initial values: \n ${printers.contentToString()}"
        )
        val benchmark = measureNanoTime {
            printers.quickSort(comparator = Comparator.comparingInt(Printer::price))
        }
        println("Result values: \n ${printers.contentToString()}")
        val resultTime = LocalTime.ofNanoOfDay(benchmark)
        println("Result Time is $resultTime \n")
    }

    private fun loadValues(): Array<Printer> {
        val printers = mutableListOf<Printer>()
        File("src/main/resources/data.csv").forEachLine {
            val (name, performance, price) = it.split(",")
            printers.add(Printer(name, performance.toInt(), price.toInt()))
        }
        return printers.toTypedArray()
    }
}