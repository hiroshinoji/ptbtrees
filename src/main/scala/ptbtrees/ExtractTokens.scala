package ptbtrees

import java.io._

import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConverters._

import edu.stanford.nlp.trees._

object ExtractTokens {

  def main(args: Array[String]) = {

    val f = args(0)
    val sentences = readFile(new File(f))

    for (sentence <- sentences) {
      println(sentence)
    }
  }

  def readFile(f: File): Seq[String] = {
    val in = new BufferedReader(new InputStreamReader(new FileInputStream(f)))
    val normalizer = new BobChrisTreeNormalizer
    // val normalizer = new GrammaticalFunctionTreeNormalizer(
    //   new PennTreebankLanguagePack, 2)
    val factory = new PennTreeReaderFactory(normalizer)
    val reader = factory.newTreeReader(in) //new PennTreeReader(in)

    val sentences = new ArrayBuffer[String]
    var t = reader.readTree
    while (t != null) {
      sentences += t.yieldWords.asScala.mkString(" ")
      t = reader.readTree
    }
    sentences
  }
}
