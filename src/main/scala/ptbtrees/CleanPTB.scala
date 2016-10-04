package ptbtrees

import java.io._

import scala.collection.mutable.ArrayBuffer

import edu.stanford.nlp.trees._

object CleanPTB {

  def main(args: Array[String]) = {

    val f = args(0)
    val trees = readFile(new File(f))

    for (t <- trees) {
      println(t)
    }
  }

  def readFile(f: File): Seq[Tree] = {
    val in = new BufferedReader(new InputStreamReader(new FileInputStream(f)))
    val normalizer = new BobChrisTreeNormalizer
    // val normalizer = new GrammaticalFunctionTreeNormalizer(
    //   new PennTreebankLanguagePack, 2)
    val factory = new PennTreeReaderFactory(normalizer)
    val reader = factory.newTreeReader(in) //new PennTreeReader(in)

    val trees = new ArrayBuffer[Tree]
    var t = reader.readTree
    while (t != null) {
      trees += t
      t = reader.readTree
    }
    trees
  }
}
