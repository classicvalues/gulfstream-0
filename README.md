# gulfstream

An idiomatic Clojure wrapper over [Graphstream](http://graphstream-project.org/)

## Installation

Add to `project.clj`:

```clojure
[helpshift/gulfstream "0.1.0"]
```

All functionality is in the core namespace:

```clojure
(require '[gulfstream.core :as gs])
```

## Quickstart

Lets start off by graphing a casual relationship between social empowerment and the avaliability of junk foods [source](http://ih.constantcontact.com/fs076/1103736801437/img/25.png?a=1110052009119).

```clojure
(-> (gs/graph
     {:attributes {:layout.quality 1.0 :layout.force 0.8}
      :dom (gs/expand {:links
                       {:poverty #{:mental-health :meals :avaliability :vegetable :government-support :stress}
                        :government-support #{:financial-stablity}
                        :financial-stablity #{:stress}
                        :jobs #{:financial-stablity :poverty}
                        :meals #{:vegetable :meals}
                        :kids-off-streets #{:safety}
                        :marketing #{:avaliability}
                        :vending-machines #{:avaliability}
                        :avaliability #{:social-disorder}
                        :social-disorder #{:safety}}
                       :elements
                       {:social-disorder    {:label "Social Disorder"}
                        :avaliability       {:label "Avaliability of Junk Food"}
                        :poverty            {:label "Poverty"}
                        :stress             {:label "Stress"}
                        :safety             {:label "Perceived Neighbourhood Safety"}
                        :financial-stablity {:label "Financial Stablity"}
                        :jobs               {:label "Jobs"}
                        :kids-off-streets   {:label "Kids off the Streets"}
                        :government-support {:label "Government Support"}
                        :meals              {:label "Healthy Meals per Day"}
                        :mental-health      {:label "Mental Health"}
                        :marketing          {:label "Unhealthy Marketing"}
                        :vending-machines   {:label "Vending Machines"}
                        :vegetable          {:label "Fruit and Vegetable"}}})})
    (gs/display))
```

Something like this will now pop up on the screen:

![Junk Food](https://cloud.githubusercontent.com/assets/1455572/9034089/aab032a8-39ea-11e5-8b72-689fa7247be5.png)


We can take a screenshot:

```clojure
(gs/screenshot "<path-to-screenshot>")
```

## Styling

Styling can be applied using css in the `:style` section of the dom:

````clojure
(-> (gs/graph
     {:attributes {:layout.quality 1.0 :layout.force 0.8}
      :dom (gs/expand {:links
                       {:poverty #{:mental-health :meals :avaliability :vegetable :government-support :stress}
                        :government-support #{:financial-stablity}
                        :financial-stablity #{:stress}
                        :jobs #{:financial-stablity :poverty}
                        :meals #{:vegetable :meals}
                        :kids-off-streets #{:safety}
                        :marketing #{:avaliability}
                        :vending-machines #{:avaliability}
                        :avaliability #{:social-disorder}
                        :social-disorder #{:safety}}
                       :elements
                       {:social-disorder    {:label "Social Disorder"}
                        :avaliability       {:label "Avaliability of Junk Food"
			                                       :ui.class ["big" "red"]}
                        :poverty            {:label "Poverty"
			                                       :ui.class ["big" "green"]}
                        :stress             {:label "Stress"}
                        :safety             {:label "Perceived Neighbourhood Safety"}
                        :financial-stablity {:label "Financial Stablity"}
                        :jobs               {:label "Jobs"
			                                       :ui.class "green"}
                        :kids-off-streets   {:label "Kids off the Streets"}
                        :government-support {:label "Government Support"}
                        :meals              {:label "Healthy Meals per Day"}
                        :mental-health      {:label "Mental Health"}
                        :marketing          {:label "Unhealthy Marketing"}
                        :vending-machines   {:label "Vending Machines"}
                        :vegetable          {:label "Fruit and Vegetable"
			                                       :ui.class "green"}}})
      :style [["node.green" {:fill-color "green"}]
              ["node.red"   {:fill-color "red"}]
              ["node.big"   {:size "20px"}]]})
    (gs/display))
```

We can then render the same graph with styling:

![styled graph](https://cloud.githubusercontent.com/assets/1455572/9034701/62992498-39ef-11e5-890d-d080c769b7cc.png)
