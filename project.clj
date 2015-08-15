(defproject helpshift/gulfstream "0.1.8"
  :description "graphing library wrapper built on top of graphstream"
  :url "https://www.github.com/helpshift/gulfstream"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [garden "1.2.5"]
                 [net.sourceforge.cssparser/cssparser "0.9.16"]
                 [im.chit/hara.object "2.2.7"]
                 [im.chit/hara.data.diff "2.2.6"]
                 [org.graphstream/gs-ui "1.3"]]
  :profiles {:dev {:dependencies [[midje "1.7.0"]
                                  [helpshift/hydrox "0.1.0"]]
                  :plugins [[lein-midje "3.1.3"]]}})
