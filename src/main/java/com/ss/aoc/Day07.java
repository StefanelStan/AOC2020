package com.ss.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day07 {
    private String inputTestRules = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "bright white bags contain 1 shiny gold bag.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
            "faded blue bags contain no other bags.\n" +
            "dotted black bags contain no other bags.";

    private String inputRules = "light gold bags contain 2 light lime bags, 1 faded green bag, 3 clear olive bags, 2 dim bronze bags.\n" +
            "muted beige bags contain 3 clear lime bags, 5 dark salmon bags, 1 pale olive bag.\n" +
            "vibrant violet bags contain 3 dark tomato bags, 3 muted indigo bags, 3 plaid turquoise bags, 3 light silver bags.\n" +
            "dull purple bags contain 2 wavy turquoise bags.\n" +
            "posh purple bags contain 4 bright lavender bags, 2 wavy chartreuse bags, 3 vibrant aqua bags.\n" +
            "striped gold bags contain 4 light magenta bags.\n" +
            "dark lime bags contain 3 plaid brown bags.\n" +
            "shiny salmon bags contain 5 light olive bags.\n" +
            "dull gold bags contain 2 dim plum bags.\n" +
            "dim olive bags contain 3 faded cyan bags.\n" +
            "faded white bags contain 2 clear brown bags, 1 mirrored green bag, 3 plaid bronze bags.\n" +
            "dull salmon bags contain 1 plaid gray bag, 4 vibrant aqua bags, 5 mirrored cyan bags.\n" +
            "striped orange bags contain 4 vibrant maroon bags, 2 dark orange bags.\n" +
            "dotted silver bags contain 2 posh red bags, 1 muted yellow bag, 5 light aqua bags, 3 pale red bags.\n" +
            "light orange bags contain 1 striped coral bag, 3 dim lime bags, 4 muted yellow bags.\n" +
            "wavy lime bags contain 5 light silver bags, 1 bright coral bag, 5 drab silver bags, 1 dark plum bag.\n" +
            "bright tan bags contain 3 clear magenta bags, 2 muted white bags, 2 drab beige bags, 5 plaid green bags.\n" +
            "dim violet bags contain 1 striped fuchsia bag, 2 mirrored green bags, 1 bright teal bag.\n" +
            "mirrored gold bags contain 1 pale aqua bag.\n" +
            "bright plum bags contain 1 faded fuchsia bag.\n" +
            "muted aqua bags contain 2 muted red bags.\n" +
            "plaid bronze bags contain 2 dim lime bags, 2 wavy coral bags, 1 vibrant lime bag, 1 dotted beige bag.\n" +
            "dim chartreuse bags contain 5 mirrored lime bags, 2 dotted tomato bags, 1 plaid turquoise bag.\n" +
            "muted lavender bags contain 4 faded salmon bags, 3 bright white bags, 3 posh fuchsia bags, 1 dotted green bag.\n" +
            "mirrored yellow bags contain 1 wavy purple bag, 5 shiny teal bags, 5 shiny cyan bags, 1 shiny crimson bag.\n" +
            "striped magenta bags contain 4 dim white bags, 2 pale white bags.\n" +
            "dull crimson bags contain 3 muted black bags, 4 dull lavender bags.\n" +
            "mirrored beige bags contain 2 posh indigo bags, 3 shiny gray bags.\n" +
            "bright blue bags contain 5 mirrored fuchsia bags.\n" +
            "plaid beige bags contain 3 mirrored cyan bags, 1 vibrant tan bag, 5 muted purple bags, 1 wavy red bag.\n" +
            "dotted indigo bags contain 5 pale fuchsia bags, 5 posh tomato bags.\n" +
            "muted coral bags contain 4 dim crimson bags, 3 dark brown bags, 2 drab fuchsia bags.\n" +
            "drab tomato bags contain 1 muted tan bag, 2 dark salmon bags, 4 faded red bags, 5 shiny olive bags.\n" +
            "dark tomato bags contain 5 mirrored salmon bags.\n" +
            "bright yellow bags contain 4 light teal bags, 1 posh white bag, 2 shiny blue bags.\n" +
            "dotted salmon bags contain 3 drab olive bags.\n" +
            "vibrant olive bags contain 2 posh teal bags, 1 clear aqua bag.\n" +
            "dotted gold bags contain 4 striped violet bags.\n" +
            "light tan bags contain 2 plaid fuchsia bags, 1 faded turquoise bag, 2 muted tomato bags.\n" +
            "drab orange bags contain 3 wavy violet bags, 1 dark fuchsia bag, 2 mirrored green bags.\n" +
            "dull coral bags contain 1 dark crimson bag.\n" +
            "light purple bags contain 4 dark gold bags, 3 plaid purple bags, 4 clear chartreuse bags.\n" +
            "wavy yellow bags contain 3 striped silver bags, 2 dull chartreuse bags.\n" +
            "dull tan bags contain 1 dim gold bag.\n" +
            "vibrant plum bags contain 4 dotted turquoise bags, 1 faded gray bag.\n" +
            "wavy tan bags contain 4 shiny plum bags, 5 faded white bags, 1 plaid plum bag.\n" +
            "dim indigo bags contain 2 clear blue bags.\n" +
            "muted teal bags contain 4 mirrored fuchsia bags, 5 faded black bags.\n" +
            "dark maroon bags contain 5 mirrored gold bags, 5 bright red bags, 1 faded gray bag.\n" +
            "mirrored aqua bags contain 4 faded turquoise bags, 1 mirrored tan bag.\n" +
            "muted violet bags contain 4 mirrored lavender bags, 3 faded salmon bags.\n" +
            "wavy orange bags contain 3 drab crimson bags, 5 posh indigo bags, 2 faded cyan bags, 5 light blue bags.\n" +
            "mirrored blue bags contain 1 dark teal bag, 4 pale orange bags.\n" +
            "muted silver bags contain 2 dim orange bags, 1 posh plum bag, 2 wavy fuchsia bags.\n" +
            "plaid magenta bags contain 3 faded blue bags, 5 vibrant lime bags, 2 faded beige bags.\n" +
            "dark lavender bags contain 3 clear olive bags.\n" +
            "posh salmon bags contain 4 dark orange bags.\n" +
            "dim silver bags contain 3 plaid blue bags, 1 posh brown bag, 1 striped white bag.\n" +
            "posh chartreuse bags contain 3 drab plum bags, 3 mirrored brown bags.\n" +
            "shiny cyan bags contain 4 faded plum bags, 5 wavy yellow bags, 2 drab maroon bags.\n" +
            "drab bronze bags contain 2 shiny turquoise bags, 4 faded white bags, 4 drab white bags.\n" +
            "dotted cyan bags contain 1 posh brown bag, 2 dark orange bags, 4 plaid bronze bags.\n" +
            "shiny beige bags contain 5 dotted cyan bags, 2 pale indigo bags.\n" +
            "drab violet bags contain 4 posh chartreuse bags, 1 drab fuchsia bag.\n" +
            "muted tomato bags contain 2 posh aqua bags.\n" +
            "drab plum bags contain 5 drab gold bags, 4 dark fuchsia bags, 5 pale gold bags, 3 dim olive bags.\n" +
            "dim brown bags contain 1 drab indigo bag, 2 pale gold bags, 5 posh fuchsia bags.\n" +
            "plaid cyan bags contain 1 light orange bag, 2 bright violet bags.\n" +
            "striped silver bags contain 2 shiny silver bags.\n" +
            "plaid tomato bags contain 3 drab cyan bags, 4 clear chartreuse bags, 3 dim coral bags, 4 shiny gray bags.\n" +
            "posh tomato bags contain 1 plaid bronze bag, 1 dim lime bag.\n" +
            "vibrant orange bags contain 5 bright aqua bags, 2 drab coral bags, 4 dull aqua bags, 3 vibrant lavender bags.\n" +
            "drab brown bags contain 1 bright orange bag, 3 drab salmon bags.\n" +
            "plaid crimson bags contain 3 dull red bags, 3 posh maroon bags, 2 dull beige bags.\n" +
            "clear aqua bags contain 5 muted cyan bags, 1 dotted teal bag.\n" +
            "pale magenta bags contain 2 light brown bags.\n" +
            "mirrored chartreuse bags contain 3 striped gold bags, 3 light silver bags, 3 dim red bags, 3 dim chartreuse bags.\n" +
            "mirrored plum bags contain 2 striped tomato bags, 1 posh aqua bag, 1 muted teal bag, 2 faded indigo bags.\n" +
            "posh teal bags contain 5 clear indigo bags, 5 plaid purple bags, 4 pale white bags, 3 drab gray bags.\n" +
            "wavy aqua bags contain 4 drab beige bags, 5 plaid black bags.\n" +
            "drab coral bags contain 3 striped tomato bags, 1 dotted cyan bag.\n" +
            "shiny chartreuse bags contain 2 mirrored cyan bags.\n" +
            "striped gray bags contain 5 striped tomato bags.\n" +
            "shiny orange bags contain 4 muted purple bags, 4 dim silver bags, 5 shiny gold bags, 3 pale orange bags.\n" +
            "dark teal bags contain no other bags.\n" +
            "dark magenta bags contain 4 pale gray bags, 1 dim purple bag, 4 drab coral bags.\n" +
            "vibrant fuchsia bags contain 4 dull olive bags.\n" +
            "light bronze bags contain 2 plaid gold bags, 2 dark white bags.\n" +
            "dotted yellow bags contain 5 bright indigo bags, 2 light silver bags, 3 wavy red bags.\n" +
            "muted purple bags contain 1 shiny blue bag, 5 faded red bags, 1 dim olive bag.\n" +
            "faded cyan bags contain 1 dark teal bag.\n" +
            "dull brown bags contain 5 vibrant aqua bags.\n" +
            "shiny white bags contain 2 dull red bags, 1 plaid orange bag, 5 muted turquoise bags.\n" +
            "light brown bags contain 4 dim coral bags, 3 faded red bags.\n" +
            "bright orange bags contain 5 dull olive bags.\n" +
            "light lime bags contain 4 light magenta bags, 5 muted violet bags.\n" +
            "shiny indigo bags contain 2 bright blue bags, 1 dotted turquoise bag, 2 clear bronze bags.\n" +
            "faded teal bags contain 4 bright brown bags, 1 light silver bag.\n" +
            "posh bronze bags contain 3 dark salmon bags, 2 plaid fuchsia bags, 1 dim white bag, 5 faded maroon bags.\n" +
            "shiny yellow bags contain 1 posh lime bag.\n" +
            "dotted beige bags contain no other bags.\n" +
            "vibrant blue bags contain 2 posh green bags, 1 faded white bag, 2 plaid red bags, 4 posh violet bags.\n" +
            "posh lime bags contain 4 bright aqua bags.\n" +
            "posh coral bags contain 5 plaid white bags, 3 faded coral bags.\n" +
            "dark yellow bags contain 3 wavy violet bags, 5 clear chartreuse bags, 5 light turquoise bags.\n" +
            "wavy bronze bags contain 2 clear brown bags, 2 muted cyan bags.\n" +
            "faded brown bags contain 5 dim lime bags, 4 dotted beige bags, 3 wavy coral bags, 1 faded gray bag.\n" +
            "vibrant gold bags contain 2 dotted maroon bags.\n" +
            "vibrant red bags contain 4 dull black bags.\n" +
            "clear beige bags contain 4 dim olive bags, 3 plaid bronze bags, 3 clear brown bags, 5 vibrant lime bags.\n" +
            "dim teal bags contain 4 plaid bronze bags, 5 striped tan bags, 1 muted olive bag.\n" +
            "dim aqua bags contain 1 faded lime bag, 4 faded gray bags, 1 posh coral bag.\n" +
            "faded tan bags contain 5 clear lime bags, 4 shiny violet bags, 2 dull aqua bags.\n" +
            "mirrored green bags contain no other bags.\n" +
            "light magenta bags contain 5 plaid gold bags.\n" +
            "striped white bags contain 1 wavy coral bag, 1 faded gray bag, 3 vibrant lime bags, 2 mirrored fuchsia bags.\n" +
            "plaid violet bags contain 3 faded indigo bags, 1 striped fuchsia bag, 5 drab salmon bags, 4 mirrored cyan bags.\n" +
            "dull cyan bags contain 4 dark chartreuse bags, 3 light gray bags.\n" +
            "light salmon bags contain 2 dark teal bags.\n" +
            "drab crimson bags contain 3 vibrant tan bags.\n" +
            "striped yellow bags contain 5 faded brown bags, 4 posh olive bags.\n" +
            "pale orange bags contain no other bags.\n" +
            "faded gold bags contain 5 light magenta bags.\n" +
            "faded beige bags contain 1 faded indigo bag, 5 wavy green bags, 5 faded crimson bags.\n" +
            "striped crimson bags contain 2 posh brown bags.\n" +
            "dark black bags contain 4 plaid lavender bags, 5 mirrored salmon bags.\n" +
            "bright beige bags contain 1 bright brown bag, 5 posh aqua bags.\n" +
            "bright gold bags contain 3 light lime bags, 2 shiny white bags.\n" +
            "bright tomato bags contain 4 dull orange bags, 4 dull blue bags.\n" +
            "light olive bags contain 4 dull blue bags, 4 plaid gray bags, 4 faded gray bags.\n" +
            "vibrant lavender bags contain 1 clear salmon bag, 2 bright lavender bags.\n" +
            "drab yellow bags contain 1 plaid black bag.\n" +
            "faded green bags contain 1 clear brown bag, 4 mirrored orange bags, 1 striped tan bag.\n" +
            "vibrant black bags contain 4 mirrored fuchsia bags.\n" +
            "bright indigo bags contain 5 plaid red bags, 1 striped chartreuse bag, 3 vibrant plum bags, 5 dark lavender bags.\n" +
            "dull plum bags contain 2 mirrored plum bags, 2 light silver bags, 1 pale indigo bag.\n" +
            "striped bronze bags contain 2 dotted blue bags.\n" +
            "muted magenta bags contain 2 dim silver bags, 5 clear purple bags.\n" +
            "striped teal bags contain 5 vibrant white bags.\n" +
            "dim bronze bags contain 2 dim crimson bags, 4 vibrant beige bags, 2 wavy turquoise bags.\n" +
            "shiny lavender bags contain 4 dim purple bags.\n" +
            "vibrant silver bags contain 1 dotted crimson bag, 2 dotted maroon bags.\n" +
            "posh yellow bags contain 4 bright salmon bags, 4 shiny lavender bags, 5 mirrored aqua bags.\n" +
            "faded bronze bags contain 2 posh brown bags, 3 clear lime bags, 4 dotted red bags, 2 striped white bags.\n" +
            "posh maroon bags contain 5 striped salmon bags, 1 light black bag.\n" +
            "pale aqua bags contain 2 shiny orange bags, 1 shiny silver bag, 2 dim violet bags.\n" +
            "plaid chartreuse bags contain 2 muted black bags, 4 muted magenta bags, 1 mirrored bronze bag, 1 posh beige bag.\n" +
            "dotted orange bags contain 2 drab indigo bags.\n" +
            "plaid gold bags contain 3 drab beige bags.\n" +
            "shiny silver bags contain 2 dull teal bags, 5 drab gray bags, 4 bright blue bags, 2 dotted cyan bags.\n" +
            "mirrored crimson bags contain 2 shiny gold bags, 5 plaid black bags, 3 drab beige bags, 1 pale beige bag.\n" +
            "pale gold bags contain 1 striped tomato bag, 5 striped white bags, 2 mirrored bronze bags, 5 dim orange bags.\n" +
            "vibrant crimson bags contain 5 faded white bags, 2 wavy coral bags.\n" +
            "dim yellow bags contain 1 vibrant coral bag, 5 faded red bags, 4 mirrored magenta bags, 4 posh indigo bags.\n" +
            "dull teal bags contain 1 plaid fuchsia bag, 3 striped blue bags.\n" +
            "striped red bags contain 4 dull lime bags.\n" +
            "muted chartreuse bags contain 5 bright crimson bags.\n" +
            "dim lavender bags contain 2 posh maroon bags.\n" +
            "wavy crimson bags contain 1 dim magenta bag, 4 dim crimson bags, 1 dull lavender bag, 3 muted fuchsia bags.\n" +
            "dull green bags contain 5 dull olive bags, 1 clear blue bag, 5 shiny salmon bags.\n" +
            "wavy red bags contain 1 dull chartreuse bag, 3 dim black bags.\n" +
            "pale blue bags contain 4 light olive bags, 3 vibrant chartreuse bags.\n" +
            "dull fuchsia bags contain 2 posh chartreuse bags.\n" +
            "dotted violet bags contain 1 shiny olive bag, 3 bright blue bags, 5 posh beige bags, 4 vibrant black bags.\n" +
            "drab white bags contain 1 plaid gold bag, 5 clear olive bags.\n" +
            "drab blue bags contain 3 muted bronze bags, 5 shiny gold bags, 4 dim olive bags.\n" +
            "plaid salmon bags contain 5 pale gold bags.\n" +
            "pale coral bags contain 3 plaid orange bags, 3 plaid fuchsia bags, 5 drab teal bags.\n" +
            "vibrant maroon bags contain 3 dim lime bags, 2 pale beige bags, 5 mirrored green bags.\n" +
            "mirrored magenta bags contain 2 striped blue bags.\n" +
            "faded blue bags contain 3 vibrant bronze bags, 2 clear maroon bags, 1 faded white bag, 3 dark cyan bags.\n" +
            "drab olive bags contain 5 wavy teal bags, 3 mirrored black bags, 5 dark gray bags, 5 dull lime bags.\n" +
            "posh white bags contain 1 plaid purple bag, 4 dark turquoise bags, 3 clear salmon bags, 1 dim orange bag.\n" +
            "dull red bags contain 4 vibrant plum bags, 3 plaid black bags, 4 dull orange bags.\n" +
            "striped tan bags contain no other bags.\n" +
            "posh blue bags contain 3 mirrored magenta bags, 1 dark plum bag, 4 wavy turquoise bags, 1 shiny coral bag.\n" +
            "drab salmon bags contain 2 bright aqua bags, 4 posh gold bags, 5 plaid blue bags.\n" +
            "striped green bags contain 5 dim black bags.\n" +
            "wavy salmon bags contain 5 pale purple bags.\n" +
            "vibrant cyan bags contain 1 dark gray bag, 1 vibrant beige bag, 5 drab violet bags, 5 dull coral bags.\n" +
            "wavy lavender bags contain 1 light magenta bag, 2 striped cyan bags.\n" +
            "faded maroon bags contain 5 light gray bags.\n" +
            "vibrant yellow bags contain 2 bright beige bags, 5 dim brown bags, 2 posh silver bags, 2 pale cyan bags.\n" +
            "dotted tomato bags contain 3 mirrored magenta bags, 3 wavy chartreuse bags, 2 wavy maroon bags.\n" +
            "striped lavender bags contain 4 shiny coral bags, 2 dim white bags, 3 faded red bags.\n" +
            "faded red bags contain 2 mirrored fuchsia bags, 1 light cyan bag, 2 vibrant lime bags, 1 mirrored green bag.\n" +
            "clear black bags contain 3 drab purple bags, 2 bright yellow bags, 2 wavy brown bags.\n" +
            "faded indigo bags contain 1 dim lime bag, 1 clear brown bag.\n" +
            "shiny tan bags contain 1 dull brown bag, 2 striped tomato bags.\n" +
            "drab teal bags contain 1 dotted turquoise bag, 4 posh fuchsia bags.\n" +
            "wavy magenta bags contain 1 dim yellow bag, 3 drab indigo bags.\n" +
            "mirrored turquoise bags contain no other bags.\n" +
            "faded lime bags contain 4 drab cyan bags, 1 clear orange bag, 5 vibrant salmon bags, 5 faded crimson bags.\n" +
            "vibrant coral bags contain 5 pale gray bags, 2 clear salmon bags.\n" +
            "muted turquoise bags contain 1 clear brown bag.\n" +
            "plaid aqua bags contain 3 dull coral bags.\n" +
            "pale indigo bags contain 1 striped brown bag, 2 bright cyan bags, 5 plaid silver bags.\n" +
            "faded tomato bags contain 1 pale red bag, 2 dotted tan bags.\n" +
            "mirrored white bags contain 4 drab fuchsia bags, 3 plaid orange bags, 4 dotted lavender bags.\n" +
            "shiny aqua bags contain 1 wavy silver bag, 4 drab green bags, 1 bright tomato bag.\n" +
            "pale cyan bags contain 1 pale gold bag, 5 dark turquoise bags.\n" +
            "mirrored salmon bags contain 5 light crimson bags, 5 muted bronze bags, 2 vibrant beige bags, 1 striped lavender bag.\n" +
            "dark gold bags contain 1 shiny olive bag.\n" +
            "muted blue bags contain 2 vibrant maroon bags, 5 wavy chartreuse bags.\n" +
            "bright fuchsia bags contain 1 posh white bag.\n" +
            "light blue bags contain 5 muted beige bags, 1 dark crimson bag, 5 mirrored brown bags, 1 posh orange bag.\n" +
            "clear salmon bags contain 1 faded brown bag, 5 dotted beige bags, 4 faded gray bags, 4 dark orange bags.\n" +
            "plaid red bags contain 3 drab silver bags, 2 dim green bags.\n" +
            "faded plum bags contain 2 posh orange bags, 5 dotted lime bags.\n" +
            "bright coral bags contain 3 plaid plum bags, 1 dark green bag, 2 striped crimson bags, 5 vibrant coral bags.\n" +
            "shiny crimson bags contain 5 bright teal bags, 4 muted magenta bags, 4 vibrant maroon bags, 3 faded cyan bags.\n" +
            "dim magenta bags contain 1 muted olive bag, 1 bright blue bag, 4 muted white bags, 5 posh gray bags.\n" +
            "pale brown bags contain 4 dotted cyan bags, 5 bright coral bags.\n" +
            "striped olive bags contain 2 bright brown bags, 4 pale gray bags, 5 dotted teal bags, 3 pale white bags.\n" +
            "posh gray bags contain 1 dark chartreuse bag.\n" +
            "dotted brown bags contain 3 plaid gold bags, 5 dim bronze bags.\n" +
            "dim lime bags contain no other bags.\n" +
            "clear crimson bags contain 2 posh orange bags, 2 plaid plum bags, 1 dark orange bag.\n" +
            "shiny turquoise bags contain 1 faded indigo bag, 3 light red bags.\n" +
            "striped plum bags contain 1 muted white bag.\n" +
            "muted crimson bags contain 1 bright teal bag.\n" +
            "plaid blue bags contain 3 dotted beige bags, 5 vibrant lime bags, 1 vibrant tan bag, 2 striped blue bags.\n" +
            "light teal bags contain 2 dotted cyan bags.\n" +
            "faded salmon bags contain 5 mirrored crimson bags.\n" +
            "shiny blue bags contain 4 posh gold bags, 3 light cyan bags, 1 clear teal bag.\n" +
            "plaid brown bags contain 2 dull lavender bags.\n" +
            "muted bronze bags contain 3 faded purple bags.\n" +
            "posh fuchsia bags contain 5 striped coral bags.\n" +
            "clear orange bags contain 1 bright blue bag, 5 posh gold bags, 5 striped crimson bags, 1 dark teal bag.\n" +
            "plaid plum bags contain 5 faded brown bags.\n" +
            "clear gray bags contain 4 mirrored fuchsia bags, 2 dim cyan bags, 3 pale gold bags, 1 dim violet bag.\n" +
            "bright lavender bags contain 1 mirrored purple bag, 4 wavy magenta bags, 2 dull black bags, 3 light silver bags.\n" +
            "pale purple bags contain 3 striped tan bags, 1 dull olive bag.\n" +
            "pale bronze bags contain 2 plaid aqua bags, 2 pale fuchsia bags, 4 bright lime bags.\n" +
            "clear blue bags contain 3 plaid beige bags.\n" +
            "drab silver bags contain 3 dim violet bags, 1 muted yellow bag, 1 pale beige bag.\n" +
            "dark silver bags contain 4 dark fuchsia bags, 4 bright green bags, 5 dim beige bags, 1 light tomato bag.\n" +
            "mirrored gray bags contain 2 striped black bags.\n" +
            "posh black bags contain 3 dull indigo bags, 3 striped beige bags, 3 dim blue bags, 2 wavy lime bags.\n" +
            "clear teal bags contain 2 dark orange bags, 4 pale beige bags, 5 clear beige bags, 4 dark teal bags.\n" +
            "pale white bags contain 2 drab gray bags, 1 muted olive bag.\n" +
            "muted fuchsia bags contain 2 clear brown bags, 4 mirrored green bags, 2 striped tan bags.\n" +
            "bright cyan bags contain 1 dotted plum bag.\n" +
            "light tomato bags contain 2 dim violet bags, 1 pale green bag, 4 dim orange bags, 1 dotted tomato bag.\n" +
            "pale turquoise bags contain 2 plaid black bags, 2 clear brown bags.\n" +
            "dim orange bags contain 1 plaid plum bag, 2 clear indigo bags, 1 dotted blue bag, 1 drab beige bag.\n" +
            "posh red bags contain 5 faded brown bags, 4 clear gray bags, 5 bright teal bags.\n" +
            "bright teal bags contain 4 clear beige bags.\n" +
            "posh lavender bags contain 1 drab beige bag, 5 dim salmon bags, 3 light crimson bags.\n" +
            "drab green bags contain 1 striped brown bag, 1 dull blue bag, 1 plaid coral bag.\n" +
            "clear coral bags contain 1 faded crimson bag, 4 light silver bags, 1 posh violet bag.\n" +
            "dark tan bags contain 5 faded brown bags.\n" +
            "vibrant aqua bags contain 1 light cyan bag, 5 bright brown bags.\n" +
            "dark blue bags contain 1 dark silver bag.\n" +
            "drab lime bags contain 3 faded white bags, 5 clear tomato bags, 1 dark turquoise bag.\n" +
            "faded lavender bags contain 1 bright violet bag, 4 posh gold bags.\n" +
            "dark orange bags contain 2 striped tan bags.\n" +
            "plaid orange bags contain 4 dark beige bags, 5 dull lavender bags, 4 striped white bags.\n" +
            "vibrant chartreuse bags contain 1 faded indigo bag, 4 clear magenta bags, 2 shiny blue bags, 2 dull teal bags.\n" +
            "dim white bags contain 3 faded white bags, 2 clear teal bags.\n" +
            "dim cyan bags contain 4 clear olive bags, 4 pale gray bags, 5 plaid bronze bags.\n" +
            "dotted chartreuse bags contain 1 bright magenta bag, 5 shiny maroon bags.\n" +
            "dull aqua bags contain 2 drab beige bags.\n" +
            "clear violet bags contain 3 pale teal bags, 3 posh tomato bags, 1 light silver bag, 2 faded coral bags.\n" +
            "pale lavender bags contain 1 drab beige bag, 2 dark teal bags.\n" +
            "clear tomato bags contain 5 muted beige bags, 1 plaid gold bag, 3 vibrant coral bags, 3 shiny silver bags.\n" +
            "clear cyan bags contain 4 faded lime bags, 2 drab tomato bags.\n" +
            "striped salmon bags contain 3 dim silver bags.\n" +
            "wavy silver bags contain 2 drab blue bags, 4 shiny green bags, 3 muted yellow bags.\n" +
            "dull indigo bags contain 5 mirrored plum bags.\n" +
            "faded coral bags contain 2 muted olive bags, 4 dark salmon bags.\n" +
            "muted olive bags contain 5 faded red bags, 1 dim lime bag, 1 striped white bag, 4 dark teal bags.\n" +
            "dotted plum bags contain 5 plaid blue bags.\n" +
            "striped cyan bags contain 4 mirrored plum bags, 2 wavy beige bags.\n" +
            "dotted olive bags contain 3 mirrored gold bags, 4 bright lavender bags, 2 dim turquoise bags.\n" +
            "plaid green bags contain 5 dark chartreuse bags, 5 mirrored bronze bags, 5 dark beige bags.\n" +
            "clear chartreuse bags contain 5 posh olive bags, 3 plaid violet bags, 3 mirrored fuchsia bags, 2 light orange bags.\n" +
            "wavy indigo bags contain 2 shiny teal bags, 3 clear olive bags.\n" +
            "shiny fuchsia bags contain 5 striped chartreuse bags, 1 light chartreuse bag.\n" +
            "shiny coral bags contain 4 dotted plum bags, 4 dull orange bags, 3 posh olive bags, 2 dark salmon bags.\n" +
            "bright black bags contain 5 drab gray bags, 1 vibrant black bag, 3 vibrant salmon bags, 3 dim silver bags.\n" +
            "bright salmon bags contain 1 shiny plum bag, 4 bright brown bags, 5 pale gray bags, 3 mirrored maroon bags.\n" +
            "faded yellow bags contain 1 light blue bag, 2 striped white bags, 3 dim lime bags, 4 wavy cyan bags.\n" +
            "plaid fuchsia bags contain 1 striped blue bag.\n" +
            "plaid lime bags contain 3 clear bronze bags, 4 dull orange bags, 1 pale aqua bag.\n" +
            "clear turquoise bags contain 1 posh aqua bag, 5 plaid black bags, 4 vibrant brown bags.\n" +
            "dull lime bags contain 3 mirrored crimson bags, 1 dotted crimson bag, 2 light lime bags, 2 light gray bags.\n" +
            "dull gray bags contain 5 bright lavender bags, 3 muted olive bags.\n" +
            "dotted turquoise bags contain 2 dim olive bags, 1 striped blue bag, 4 clear indigo bags.\n" +
            "vibrant purple bags contain 4 light olive bags, 4 mirrored salmon bags, 4 muted red bags.\n" +
            "dark cyan bags contain 2 dim lime bags, 5 light olive bags, 4 muted red bags, 3 drab indigo bags.\n" +
            "vibrant turquoise bags contain 4 light indigo bags.\n" +
            "bright bronze bags contain 2 pale green bags, 5 faded gray bags.\n" +
            "clear maroon bags contain 3 faded coral bags.\n" +
            "faded purple bags contain 5 plaid plum bags, 3 striped blue bags, 2 vibrant tan bags, 3 dark orange bags.\n" +
            "light indigo bags contain 2 wavy bronze bags, 5 bright lime bags, 4 drab lime bags, 2 dotted chartreuse bags.\n" +
            "dotted bronze bags contain 5 faded brown bags, 4 drab silver bags, 3 drab chartreuse bags.\n" +
            "mirrored lavender bags contain 3 dim salmon bags.\n" +
            "clear gold bags contain 1 dull plum bag.\n" +
            "vibrant beige bags contain 5 drab crimson bags.\n" +
            "dull yellow bags contain 5 mirrored green bags, 4 plaid bronze bags, 5 plaid blue bags, 4 dull orange bags.\n" +
            "dotted black bags contain 2 dull fuchsia bags, 2 light fuchsia bags, 3 mirrored lavender bags, 1 muted coral bag.\n" +
            "dotted maroon bags contain 3 plaid coral bags, 5 dotted cyan bags.\n" +
            "dim tomato bags contain 4 pale tomato bags, 3 striped beige bags.\n" +
            "wavy violet bags contain 4 mirrored crimson bags, 4 plaid bronze bags, 4 faded turquoise bags, 4 drab chartreuse bags.\n" +
            "shiny bronze bags contain 3 muted chartreuse bags, 3 drab gold bags.\n" +
            "faded fuchsia bags contain 1 bright blue bag, 1 dim purple bag, 1 dim magenta bag.\n" +
            "plaid turquoise bags contain 2 shiny olive bags, 5 dull orange bags, 2 dark fuchsia bags, 3 clear purple bags.\n" +
            "mirrored teal bags contain 4 drab cyan bags, 2 striped green bags.\n" +
            "clear purple bags contain 3 dull teal bags, 2 vibrant tan bags, 5 vibrant maroon bags.\n" +
            "dotted blue bags contain 2 muted white bags, 2 dark green bags, 2 faded purple bags, 2 plaid blue bags.\n" +
            "light violet bags contain 5 dark salmon bags, 5 striped orange bags.\n" +
            "light beige bags contain 2 muted chartreuse bags, 4 striped brown bags, 3 wavy maroon bags.\n" +
            "wavy purple bags contain 4 dark violet bags, 3 drab fuchsia bags, 4 dull lavender bags, 3 drab lime bags.\n" +
            "light silver bags contain 4 posh brown bags, 3 vibrant crimson bags.\n" +
            "wavy white bags contain 5 mirrored fuchsia bags, 2 dotted turquoise bags, 5 striped tomato bags.\n" +
            "striped purple bags contain 4 dull chartreuse bags.\n" +
            "wavy teal bags contain 1 light chartreuse bag, 3 dark green bags.\n" +
            "vibrant indigo bags contain 2 dim coral bags.\n" +
            "pale red bags contain 3 drab cyan bags, 1 muted tan bag.\n" +
            "dark aqua bags contain 2 faded brown bags, 1 shiny gold bag, 3 light cyan bags, 2 light green bags.\n" +
            "dotted tan bags contain 2 drab beige bags, 2 faded gray bags.\n" +
            "faded aqua bags contain 5 faded brown bags.\n" +
            "drab turquoise bags contain 5 drab teal bags.\n" +
            "dark turquoise bags contain 2 dim teal bags, 1 dim coral bag, 1 clear beige bag.\n" +
            "wavy maroon bags contain 1 dim violet bag, 4 clear bronze bags.\n" +
            "dark gray bags contain 2 bright blue bags.\n" +
            "mirrored coral bags contain 1 clear lime bag, 1 posh gray bag.\n" +
            "dim red bags contain 3 plaid aqua bags, 4 plaid salmon bags, 3 pale gray bags, 4 wavy indigo bags.\n" +
            "dull maroon bags contain 3 light silver bags, 1 dim lime bag, 2 striped silver bags.\n" +
            "vibrant salmon bags contain 1 dark gray bag, 2 dotted cyan bags, 2 drab gray bags, 3 muted tan bags.\n" +
            "vibrant lime bags contain no other bags.\n" +
            "wavy blue bags contain 5 bright maroon bags, 2 dull plum bags, 4 pale magenta bags.\n" +
            "dim purple bags contain 3 dull indigo bags.\n" +
            "muted indigo bags contain 5 posh orange bags, 4 dim yellow bags.\n" +
            "posh gold bags contain 2 clear beige bags, 3 vibrant lime bags.\n" +
            "plaid purple bags contain 4 faded brown bags, 3 shiny blue bags, 1 faded white bag.\n" +
            "clear lime bags contain 5 posh aqua bags, 2 posh fuchsia bags, 1 clear teal bag, 4 faded cyan bags.\n" +
            "bright brown bags contain 5 plaid bronze bags, 4 faded indigo bags.\n" +
            "striped maroon bags contain 1 faded turquoise bag, 3 drab cyan bags, 5 dark gray bags, 2 pale black bags.\n" +
            "faded violet bags contain 4 drab crimson bags.\n" +
            "muted brown bags contain 2 bright tomato bags, 3 dim gold bags, 5 dull blue bags.\n" +
            "posh magenta bags contain 2 dark fuchsia bags.\n" +
            "vibrant green bags contain 3 dark fuchsia bags.\n" +
            "shiny tomato bags contain 2 light turquoise bags, 5 drab green bags, 1 posh gold bag.\n" +
            "faded olive bags contain 1 shiny purple bag, 4 wavy tan bags, 4 wavy violet bags, 1 muted fuchsia bag.\n" +
            "mirrored fuchsia bags contain 1 clear brown bag.\n" +
            "faded magenta bags contain 3 striped white bags, 3 posh tomato bags, 3 striped lime bags.\n" +
            "dim crimson bags contain 5 mirrored brown bags, 1 faded black bag, 1 dark orange bag.\n" +
            "dark green bags contain 2 dotted beige bags, 5 plaid blue bags.\n" +
            "dotted purple bags contain 4 shiny black bags, 1 muted violet bag, 1 drab green bag, 3 faded yellow bags.\n" +
            "posh turquoise bags contain 3 shiny plum bags.\n" +
            "muted gray bags contain 4 dull gray bags, 4 posh teal bags, 5 plaid gray bags.\n" +
            "shiny teal bags contain 2 pale beige bags.\n" +
            "shiny olive bags contain 1 striped tan bag, 3 mirrored turquoise bags.\n" +
            "dull white bags contain 2 pale orange bags, 1 dim magenta bag, 4 drab maroon bags.\n" +
            "drab aqua bags contain 1 wavy red bag.\n" +
            "dotted teal bags contain 3 shiny green bags, 3 drab beige bags, 1 drab crimson bag.\n" +
            "light cyan bags contain 2 mirrored green bags, 5 dotted beige bags, 5 faded white bags, 3 mirrored fuchsia bags.\n" +
            "dim maroon bags contain 1 drab fuchsia bag, 1 mirrored salmon bag.\n" +
            "mirrored maroon bags contain 4 muted white bags, 2 striped tan bags, 2 dark teal bags.\n" +
            "dark brown bags contain 1 striped bronze bag, 5 striped plum bags, 3 muted bronze bags, 2 striped lime bags.\n" +
            "plaid gray bags contain 1 clear brown bag, 5 shiny orange bags, 4 posh bronze bags, 5 light cyan bags.\n" +
            "dim gold bags contain 4 striped tomato bags, 5 striped fuchsia bags, 4 striped white bags, 1 clear brown bag.\n" +
            "drab tan bags contain 5 plaid fuchsia bags, 1 dim teal bag, 4 plaid gold bags.\n" +
            "bright aqua bags contain 4 faded indigo bags, 3 shiny blue bags, 4 posh aqua bags, 5 wavy tan bags.\n" +
            "pale lime bags contain 4 muted blue bags, 5 wavy purple bags.\n" +
            "plaid maroon bags contain 2 dim black bags, 1 drab indigo bag.\n" +
            "wavy gray bags contain 4 drab orange bags.\n" +
            "drab gold bags contain 1 dark gray bag, 4 pale gold bags.\n" +
            "plaid teal bags contain 2 dim teal bags, 1 vibrant lavender bag.\n" +
            "dark salmon bags contain 4 plaid black bags, 2 dim lime bags, 4 pale orange bags, 3 pale beige bags.\n" +
            "plaid lavender bags contain 3 faded red bags, 2 plaid aqua bags.\n" +
            "light fuchsia bags contain 3 dim violet bags.\n" +
            "faded chartreuse bags contain 2 mirrored gold bags, 5 drab gold bags, 3 mirrored salmon bags.\n" +
            "wavy beige bags contain 2 dotted salmon bags, 4 muted white bags.\n" +
            "striped tomato bags contain 4 drab cyan bags.\n" +
            "dotted white bags contain 4 bright green bags, 1 light brown bag.\n" +
            "muted yellow bags contain 3 dim violet bags, 1 posh aqua bag, 2 muted teal bags.\n" +
            "light chartreuse bags contain 4 posh aqua bags, 2 dim coral bags.\n" +
            "muted maroon bags contain 1 mirrored cyan bag, 4 dim olive bags.\n" +
            "pale yellow bags contain 3 bright olive bags.\n" +
            "dull bronze bags contain 2 plaid maroon bags, 2 vibrant bronze bags.\n" +
            "shiny gold bags contain 5 clear brown bags, 5 plaid fuchsia bags, 4 bright teal bags, 1 striped white bag.\n" +
            "posh crimson bags contain 4 vibrant plum bags.\n" +
            "clear silver bags contain 5 dim beige bags, 1 dark olive bag.\n" +
            "striped violet bags contain 5 posh orange bags, 1 vibrant crimson bag.\n" +
            "muted green bags contain 1 bright crimson bag.\n" +
            "shiny gray bags contain 4 striped maroon bags, 5 muted plum bags, 2 light chartreuse bags.\n" +
            "wavy turquoise bags contain 1 pale gold bag.\n" +
            "clear olive bags contain 4 plaid fuchsia bags.\n" +
            "drab indigo bags contain 1 clear purple bag, 4 light silver bags, 2 mirrored cyan bags, 2 clear lime bags.\n" +
            "dim salmon bags contain 1 pale aqua bag, 5 posh fuchsia bags, 4 plaid coral bags, 1 pale orange bag.\n" +
            "light black bags contain 3 muted chartreuse bags.\n" +
            "plaid indigo bags contain 3 plaid fuchsia bags, 2 muted tomato bags, 3 muted bronze bags, 1 drab white bag.\n" +
            "light crimson bags contain 2 striped chartreuse bags, 4 bright teal bags, 3 striped fuchsia bags.\n" +
            "bright purple bags contain 2 shiny violet bags.\n" +
            "dark bronze bags contain 3 striped violet bags, 4 clear beige bags.\n" +
            "dark white bags contain 5 faded white bags, 5 striped fuchsia bags, 2 vibrant lime bags, 5 striped tan bags.\n" +
            "mirrored orange bags contain 4 wavy aqua bags.\n" +
            "mirrored cyan bags contain 5 bright bronze bags.\n" +
            "dull blue bags contain 2 bright brown bags, 2 dim plum bags.\n" +
            "posh indigo bags contain 1 posh lime bag.\n" +
            "vibrant brown bags contain 1 bright indigo bag, 2 striped purple bags, 5 mirrored lime bags, 2 plaid plum bags.\n" +
            "wavy coral bags contain no other bags.\n" +
            "posh cyan bags contain 1 plaid plum bag, 2 plaid gold bags, 3 shiny plum bags.\n" +
            "vibrant tan bags contain 5 mirrored turquoise bags, 3 faded gray bags, 5 posh brown bags, 3 clear brown bags.\n" +
            "mirrored black bags contain 5 striped fuchsia bags, 1 striped tan bag, 3 pale green bags.\n" +
            "bright olive bags contain 1 bright orange bag, 4 drab gold bags, 3 dim cyan bags, 2 drab plum bags.\n" +
            "striped blue bags contain 3 dark white bags, 1 clear beige bag, 3 dim olive bags.\n" +
            "dim turquoise bags contain 4 muted turquoise bags, 1 dotted tomato bag, 4 muted brown bags.\n" +
            "posh green bags contain 4 dim gray bags, 4 clear brown bags.\n" +
            "dull magenta bags contain 3 bright plum bags.\n" +
            "dark red bags contain 2 muted magenta bags, 2 dark beige bags, 2 shiny black bags.\n" +
            "pale black bags contain 2 striped bronze bags.\n" +
            "dotted red bags contain 2 striped blue bags, 3 dim violet bags, 3 faded maroon bags.\n" +
            "dark chartreuse bags contain 5 striped orange bags, 5 dark white bags.\n" +
            "clear lavender bags contain 2 faded crimson bags, 5 clear purple bags, 3 vibrant tan bags.\n" +
            "vibrant white bags contain 1 drab crimson bag, 5 dim violet bags.\n" +
            "drab lavender bags contain 3 clear yellow bags, 5 shiny tan bags.\n" +
            "wavy cyan bags contain 5 shiny violet bags.\n" +
            "faded black bags contain 2 posh aqua bags, 5 bright teal bags, 1 posh orange bag, 4 vibrant coral bags.\n" +
            "mirrored tomato bags contain 3 muted cyan bags, 3 drab brown bags, 1 striped orange bag.\n" +
            "faded orange bags contain 3 plaid fuchsia bags, 5 mirrored crimson bags, 2 pale aqua bags, 2 dull lavender bags.\n" +
            "muted salmon bags contain 1 wavy tan bag, 2 muted chartreuse bags, 2 posh green bags, 5 shiny magenta bags.\n" +
            "pale plum bags contain 4 dull teal bags, 1 striped violet bag, 2 wavy crimson bags, 2 posh violet bags.\n" +
            "shiny magenta bags contain 3 muted yellow bags, 5 light beige bags, 1 dull white bag, 4 striped lavender bags.\n" +
            "plaid black bags contain 4 mirrored green bags.\n" +
            "clear plum bags contain 5 posh violet bags.\n" +
            "bright silver bags contain 2 dull yellow bags, 3 striped red bags, 3 dotted olive bags, 5 bright salmon bags.\n" +
            "muted gold bags contain 1 dull olive bag.\n" +
            "vibrant tomato bags contain 4 shiny blue bags, 1 bright indigo bag.\n" +
            "dim black bags contain 1 plaid gold bag, 2 muted white bags.\n" +
            "plaid white bags contain 2 muted cyan bags, 1 mirrored magenta bag, 3 striped red bags, 2 striped violet bags.\n" +
            "drab maroon bags contain 1 dotted cyan bag, 3 shiny orange bags.\n" +
            "shiny purple bags contain 3 posh purple bags.\n" +
            "shiny violet bags contain 3 dark teal bags, 3 shiny olive bags, 4 dull cyan bags, 1 dim plum bag.\n" +
            "dull chartreuse bags contain 2 bright tan bags, 2 wavy fuchsia bags, 4 bright teal bags, 1 posh violet bag.\n" +
            "striped fuchsia bags contain 5 dotted beige bags.\n" +
            "muted lime bags contain 1 vibrant tan bag.\n" +
            "dotted coral bags contain 5 mirrored magenta bags, 4 wavy blue bags.\n" +
            "bright turquoise bags contain 5 pale indigo bags.\n" +
            "bright maroon bags contain 4 plaid salmon bags, 3 wavy coral bags, 4 dull orange bags, 1 pale green bag.\n" +
            "dim green bags contain 4 posh olive bags, 4 dim white bags, 3 clear orange bags.\n" +
            "mirrored bronze bags contain 4 mirrored fuchsia bags.\n" +
            "shiny maroon bags contain 1 wavy maroon bag, 1 drab gray bag, 1 posh white bag.\n" +
            "wavy olive bags contain 1 muted purple bag, 1 shiny brown bag, 5 faded tomato bags.\n" +
            "dotted crimson bags contain 2 shiny blue bags, 4 dotted blue bags, 5 vibrant crimson bags.\n" +
            "mirrored olive bags contain 3 muted bronze bags, 1 drab tomato bag, 3 drab violet bags.\n" +
            "light aqua bags contain 3 faded cyan bags, 4 shiny white bags.\n" +
            "clear fuchsia bags contain 3 bright blue bags.\n" +
            "light green bags contain 2 dim brown bags, 4 drab green bags.\n" +
            "bright magenta bags contain 1 mirrored turquoise bag, 2 dark fuchsia bags, 5 shiny plum bags.\n" +
            "pale fuchsia bags contain 4 wavy purple bags, 2 striped salmon bags, 4 pale black bags, 3 dotted teal bags.\n" +
            "posh tan bags contain 3 plaid purple bags.\n" +
            "dull tomato bags contain 2 clear salmon bags, 2 striped yellow bags, 5 pale indigo bags.\n" +
            "bright white bags contain 1 drab white bag, 4 dim violet bags.\n" +
            "bright gray bags contain 5 muted yellow bags, 5 vibrant crimson bags.\n" +
            "dull silver bags contain 2 muted purple bags.\n" +
            "dotted gray bags contain 2 mirrored magenta bags, 1 dark lavender bag, 1 clear blue bag, 4 faded magenta bags.\n" +
            "wavy gold bags contain 3 mirrored green bags, 5 pale aqua bags.\n" +
            "shiny plum bags contain 5 plaid blue bags, 2 muted white bags, 5 pale gray bags, 2 faded indigo bags.\n" +
            "posh plum bags contain 4 wavy magenta bags, 3 mirrored plum bags.\n" +
            "clear bronze bags contain 4 bright aqua bags, 4 dim white bags, 4 plaid blue bags, 5 plaid black bags.\n" +
            "vibrant teal bags contain 2 light violet bags, 4 clear orange bags, 1 shiny plum bag, 1 light cyan bag.\n" +
            "clear red bags contain 2 drab tan bags.\n" +
            "striped coral bags contain 1 shiny olive bag, 1 dark teal bag, 3 dark white bags.\n" +
            "striped aqua bags contain 4 wavy teal bags, 2 dull chartreuse bags, 3 mirrored cyan bags, 5 plaid gray bags.\n" +
            "drab purple bags contain 1 faded fuchsia bag, 5 dull chartreuse bags, 1 light white bag, 5 posh gold bags.\n" +
            "mirrored brown bags contain 5 bright aqua bags, 5 shiny blue bags, 5 dotted blue bags, 1 posh fuchsia bag.\n" +
            "dim gray bags contain 4 vibrant chartreuse bags, 5 clear beige bags, 1 shiny orange bag, 5 light chartreuse bags.\n" +
            "mirrored purple bags contain 3 shiny gold bags, 4 plaid aqua bags, 4 wavy gold bags.\n" +
            "drab black bags contain 4 faded aqua bags.\n" +
            "pale tomato bags contain 3 vibrant gold bags, 2 dotted cyan bags, 3 wavy brown bags, 5 bright violet bags.\n" +
            "muted plum bags contain 5 dull white bags, 5 drab chartreuse bags, 4 clear gray bags.\n" +
            "bright lime bags contain 1 light chartreuse bag.\n" +
            "light yellow bags contain 1 vibrant teal bag, 1 dull teal bag.\n" +
            "dark fuchsia bags contain 3 dim plum bags, 5 faded purple bags.\n" +
            "dim blue bags contain 5 striped coral bags, 3 drab fuchsia bags, 5 drab salmon bags.\n" +
            "posh orange bags contain 2 pale gray bags, 4 plaid bronze bags, 5 vibrant tan bags.\n" +
            "striped beige bags contain 3 mirrored crimson bags, 3 muted fuchsia bags.\n" +
            "dim fuchsia bags contain 5 clear white bags.\n" +
            "dull orange bags contain 2 striped crimson bags, 2 dark white bags, 1 dark turquoise bag, 3 shiny olive bags.\n" +
            "drab fuchsia bags contain 3 dark crimson bags, 5 clear magenta bags, 5 faded brown bags.\n" +
            "dim tan bags contain 3 dull indigo bags, 3 clear magenta bags.\n" +
            "clear green bags contain 3 bright blue bags, 4 clear teal bags, 2 pale indigo bags.\n" +
            "shiny black bags contain 1 mirrored brown bag.\n" +
            "pale maroon bags contain 2 faded lime bags, 2 wavy red bags, 1 dark orange bag.\n" +
            "faded crimson bags contain 1 posh aqua bag, 5 bright brown bags, 4 dull teal bags, 4 striped orange bags.\n" +
            "muted tan bags contain 2 pale gold bags, 3 striped magenta bags, 5 plaid gold bags, 5 striped fuchsia bags.\n" +
            "light turquoise bags contain 2 dull plum bags.\n" +
            "dull lavender bags contain 3 dark green bags, 3 light brown bags, 2 posh fuchsia bags, 5 posh bronze bags.\n" +
            "pale olive bags contain 5 striped blue bags, 1 striped coral bag, 2 muted white bags.\n" +
            "dark crimson bags contain 1 bright red bag.\n" +
            "vibrant gray bags contain 1 clear coral bag, 4 posh aqua bags, 5 clear brown bags, 5 dull chartreuse bags.\n" +
            "plaid tan bags contain 2 bright coral bags, 3 wavy salmon bags.\n" +
            "bright crimson bags contain 4 clear indigo bags, 3 dim plum bags, 4 posh brown bags.\n" +
            "dotted magenta bags contain 5 bright lime bags, 2 dotted coral bags.\n" +
            "posh aqua bags contain 5 vibrant lime bags, 5 plaid fuchsia bags.\n" +
            "striped turquoise bags contain 5 pale lavender bags.\n" +
            "pale chartreuse bags contain 4 mirrored tan bags, 5 mirrored black bags.\n" +
            "pale tan bags contain 4 plaid beige bags, 3 light tomato bags, 1 dark tan bag, 4 faded lime bags.\n" +
            "wavy plum bags contain 5 dark crimson bags, 4 dim black bags.\n" +
            "posh brown bags contain 3 dark teal bags, 5 striped white bags.\n" +
            "mirrored tan bags contain 3 clear maroon bags, 4 mirrored green bags, 1 dotted red bag, 1 wavy aqua bag.\n" +
            "dotted fuchsia bags contain 3 clear lime bags, 2 dim plum bags, 2 bright salmon bags, 5 faded violet bags.\n" +
            "drab cyan bags contain 4 striped coral bags, 5 faded gray bags, 2 posh orange bags.\n" +
            "light red bags contain 5 faded black bags.\n" +
            "plaid yellow bags contain 3 striped green bags, 4 striped olive bags, 1 mirrored lavender bag.\n" +
            "muted black bags contain 2 muted turquoise bags, 3 wavy bronze bags, 5 wavy teal bags.\n" +
            "plaid silver bags contain 2 drab maroon bags, 2 wavy maroon bags, 5 dark tan bags.\n" +
            "dark coral bags contain 1 posh bronze bag, 5 bright coral bags.\n" +
            "bright violet bags contain 3 posh brown bags, 4 pale orange bags, 2 muted olive bags, 2 posh orange bags.\n" +
            "pale silver bags contain 3 pale fuchsia bags, 4 bright cyan bags.\n" +
            "dim plum bags contain 1 faded brown bag.\n" +
            "mirrored red bags contain 3 dull magenta bags, 2 light gold bags.\n" +
            "posh beige bags contain 5 plaid turquoise bags, 3 clear bronze bags, 5 plaid silver bags.\n" +
            "faded silver bags contain 4 muted violet bags, 3 muted tomato bags, 1 bright yellow bag.\n" +
            "dim coral bags contain 1 faded brown bag, 4 drab cyan bags, 1 shiny olive bag.\n" +
            "drab beige bags contain 5 mirrored fuchsia bags, 1 faded brown bag.\n" +
            "dark purple bags contain 1 striped tan bag, 2 light maroon bags.\n" +
            "drab magenta bags contain 4 dim silver bags, 4 mirrored silver bags, 5 muted tomato bags.\n" +
            "muted orange bags contain 5 dim olive bags, 5 pale brown bags, 2 mirrored black bags, 3 posh green bags.\n" +
            "dotted aqua bags contain 2 faded turquoise bags, 4 light yellow bags, 4 dotted lavender bags.\n" +
            "pale salmon bags contain 4 light cyan bags, 4 bright plum bags.\n" +
            "bright red bags contain 3 bright coral bags, 4 clear brown bags, 1 bright teal bag.\n" +
            "striped lime bags contain 5 bright yellow bags, 1 drab maroon bag, 5 muted silver bags.\n" +
            "clear magenta bags contain 5 light teal bags, 5 dotted cyan bags, 1 pale orange bag.\n" +
            "dull beige bags contain 1 posh cyan bag, 5 dark orange bags, 3 pale cyan bags, 5 drab salmon bags.\n" +
            "striped chartreuse bags contain 4 wavy maroon bags.\n" +
            "pale gray bags contain 1 plaid black bag.\n" +
            "dull black bags contain 3 dull brown bags.\n" +
            "dotted green bags contain 3 shiny maroon bags.\n" +
            "faded turquoise bags contain 2 dark violet bags.\n" +
            "wavy green bags contain 5 light gray bags, 5 vibrant lime bags.\n" +
            "light maroon bags contain 2 dotted teal bags, 3 striped fuchsia bags.\n" +
            "striped indigo bags contain 2 dim crimson bags.\n" +
            "shiny green bags contain 5 mirrored cyan bags, 5 faded red bags, 1 light silver bag, 4 mirrored black bags.\n" +
            "clear indigo bags contain 2 faded gray bags, 2 mirrored green bags.\n" +
            "vibrant magenta bags contain 4 muted silver bags, 3 bright crimson bags.\n" +
            "mirrored violet bags contain 1 dull blue bag.\n" +
            "clear yellow bags contain 1 plaid purple bag, 2 vibrant crimson bags, 3 faded white bags, 4 plaid gold bags.\n" +
            "light white bags contain 4 clear magenta bags, 4 drab green bags, 2 clear chartreuse bags.\n" +
            "striped brown bags contain 4 drab gold bags, 4 plaid red bags, 2 dim coral bags, 4 dim teal bags.\n" +
            "pale crimson bags contain 4 dim green bags, 2 striped crimson bags, 1 striped coral bag, 3 dark salmon bags.\n" +
            "dull olive bags contain 1 striped yellow bag, 2 bright aqua bags.\n" +
            "dark olive bags contain 2 faded indigo bags, 4 dim orange bags, 5 shiny silver bags, 5 dotted turquoise bags.\n" +
            "drab chartreuse bags contain 1 shiny olive bag, 1 posh tomato bag, 1 dark turquoise bag.\n" +
            "pale green bags contain 3 pale gray bags, 1 dim violet bag, 3 striped crimson bags, 3 faded cyan bags.\n" +
            "light gray bags contain 2 pale white bags, 1 dark beige bag, 1 clear purple bag.\n" +
            "plaid olive bags contain 5 drab aqua bags, 1 plaid bronze bag, 4 clear brown bags.\n" +
            "mirrored indigo bags contain 3 striped bronze bags, 3 faded green bags, 2 dotted green bags, 3 dull olive bags.\n" +
            "wavy brown bags contain 4 pale maroon bags.\n" +
            "shiny lime bags contain 2 posh gold bags, 5 posh black bags.\n" +
            "mirrored silver bags contain 4 pale cyan bags, 1 bright bronze bag, 1 mirrored blue bag.\n" +
            "shiny red bags contain 2 wavy purple bags, 5 drab yellow bags.\n" +
            "light coral bags contain 2 pale gold bags.\n" +
            "posh olive bags contain 2 bright aqua bags.\n" +
            "striped black bags contain 3 bright blue bags, 1 light salmon bag, 1 mirrored salmon bag.\n" +
            "dotted lime bags contain 5 muted indigo bags, 2 striped coral bags, 1 shiny orange bag, 4 dim black bags.\n" +
            "wavy fuchsia bags contain 4 clear magenta bags.\n" +
            "light plum bags contain 3 shiny maroon bags.\n" +
            "shiny brown bags contain 1 faded brown bag, 5 light teal bags.\n" +
            "clear tan bags contain 3 dark teal bags, 2 bright plum bags.\n" +
            "pale violet bags contain 1 clear turquoise bag, 4 dark tan bags, 3 muted green bags, 3 posh magenta bags.\n" +
            "plaid coral bags contain 2 faded red bags, 1 faded indigo bag, 4 striped blue bags, 5 vibrant maroon bags.\n" +
            "drab red bags contain 3 mirrored white bags, 5 drab tomato bags, 3 vibrant chartreuse bags, 2 faded crimson bags.\n" +
            "wavy chartreuse bags contain 1 bright brown bag, 2 vibrant aqua bags, 2 drab teal bags.\n" +
            "dull turquoise bags contain 1 dotted chartreuse bag, 1 wavy lime bag, 1 faded gold bag.\n" +
            "wavy tomato bags contain 4 bright orange bags, 4 shiny fuchsia bags, 1 bright gray bag, 1 posh violet bag.\n" +
            "mirrored lime bags contain 1 vibrant salmon bag, 5 dull white bags, 5 dotted lavender bags, 1 dull yellow bag.\n" +
            "muted white bags contain 4 muted olive bags, 3 mirrored green bags, 2 striped coral bags.\n" +
            "muted red bags contain 3 pale indigo bags, 2 dim violet bags, 2 bright red bags.\n" +
            "dotted lavender bags contain 1 clear indigo bag, 5 muted cyan bags, 5 plaid gray bags, 2 plaid aqua bags.\n" +
            "light lavender bags contain 3 drab tomato bags, 1 wavy tan bag, 1 muted magenta bag, 1 striped magenta bag.\n" +
            "faded gray bags contain 4 faded cyan bags.\n" +
            "dark plum bags contain 5 dim violet bags, 1 light teal bag, 3 faded brown bags, 1 plaid gold bag.\n" +
            "vibrant bronze bags contain 1 drab gray bag, 2 faded gray bags.\n" +
            "clear white bags contain 2 dark fuchsia bags, 2 dark gray bags.\n" +
            "pale beige bags contain 1 mirrored fuchsia bag.\n" +
            "bright chartreuse bags contain 3 clear crimson bags.\n" +
            "drab gray bags contain 2 faded gray bags, 4 posh orange bags, 3 dull teal bags, 4 shiny plum bags.\n" +
            "wavy black bags contain 1 pale maroon bag.\n" +
            "dark beige bags contain 1 faded gray bag.\n" +
            "dark violet bags contain 1 muted tan bag, 5 faded brown bags, 3 plaid black bags.\n" +
            "dim beige bags contain 1 dotted turquoise bag, 5 dim teal bags, 3 mirrored crimson bags.\n" +
            "posh silver bags contain 3 striped orange bags, 4 posh teal bags.\n" +
            "muted cyan bags contain 2 drab salmon bags, 1 pale olive bag, 2 dark plum bags.\n" +
            "dark indigo bags contain 2 dim magenta bags, 3 bright orange bags, 4 clear white bags.\n" +
            "dull violet bags contain 2 pale bronze bags, 2 mirrored blue bags.\n" +
            "pale teal bags contain 5 striped maroon bags, 3 pale gray bags.\n" +
            "bright green bags contain 4 drab green bags, 3 drab indigo bags, 5 dull blue bags.\n" +
            "posh violet bags contain 5 wavy white bags.\n" +
            "clear brown bags contain no other bags.\n";

    public int howManyBagsContain(String bagType) {
        return howManyBagsContain(inputTestRules, bagType);
    }

    public int howManyBagsContain(String data, String bagType) {
        String[] rules = data.split("\n");
        Map<String, Integer> itemIds = new HashMap<>();
        Map<Integer, Set<Integer>> rulesMap = new HashMap<>();
        sortBagsAndRules(rules, itemIds, rulesMap);
        return countHowManyBagCanContains(bagType, itemIds, rulesMap);

    }

    public int howManyBagsInside(String bagType) {
        String[] rules = inputRules.split("\n");
        Map<String, Integer> itemIds = new HashMap<>();
        Map<Integer, Set<Integer>> rulesMap = new HashMap<>();
        sortBagsAndRules(rules, itemIds, rulesMap);


        return howManyBagsInside(bagType, itemIds, rulesMap, rules);
    }

    private int howManyBagsInside(String bagType, Map<String, Integer> itemIds, Map<Integer, Set<Integer>> rulesMap, String[] rules) {
        int bagId = itemIds.get(bagType);
        Map<Integer, Integer> contentIdAndQuantity = getSmallerBagsOf(bagId, rules[bagId], itemIds, rulesMap);
        List<Integer> smallerBagsIds = new ArrayList<>();
        List<Integer> smallerBagsQuantities = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : contentIdAndQuantity.entrySet()) {
            smallerBagsIds.add(entry.getKey());
            smallerBagsQuantities.add(entry.getValue());
        }
        boolean finished = false;
        int currentIndex = 0;
        while (!finished) {
            List<Integer> tempSmallerBagsIds = new ArrayList<>();
            List<Integer> tempSmallerBagsQuantities = new ArrayList<>();
            for (int i = currentIndex; i < smallerBagsIds.size(); i++) {
                Map<Integer, Integer> tempMap = getSmallerBagsOf(smallerBagsIds.get(i), smallerBagsQuantities.get(i), rules[smallerBagsIds.get(i)], itemIds, rulesMap);
                if (!tempMap.isEmpty()) {
                    for(Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                        tempSmallerBagsIds.add(entry.getKey());
                        tempSmallerBagsQuantities.add(entry.getValue());
                    }
                }
            }
            if (tempSmallerBagsIds.isEmpty()) {
                finished = true;
            } else {
                currentIndex = smallerBagsIds.size();
                smallerBagsIds.addAll(tempSmallerBagsIds);
                smallerBagsQuantities.addAll(tempSmallerBagsQuantities);
            }

        }
        // https://adventofcode.com/2020/day/7#part2
        int sum = 0;
        for (int i = 0; i < smallerBagsQuantities.size(); i++) {
            sum += smallerBagsQuantities.get(i);
        }
        // sum+=smallerBagsQuantities.size();
        return sum;
    }

    private Map<Integer, Integer> getSmallerBagsOf(int bagId, String rule, Map<String, Integer> itemIds, Map<Integer, Set<Integer>> rulesMap) {
        return getSmallerBagsOf(bagId, 1, rule, itemIds, rulesMap);
    }

    private int countHowManyBagCanContains(String bagType, Map<String, Integer> itemIds, Map<Integer, Set<Integer>> rulesMap) {
        int bagId = itemIds.get(bagType);
        List<Integer> biggerBags = new ArrayList<>(getBagsThatContainBag(bagId, rulesMap));
        boolean finished = false;
        int currentIndex = 0;
        while (!finished) {
            Set<Integer> tempSet = new HashSet<>();
            for (int i = currentIndex; i < biggerBags.size(); i++) {
                Set<Integer> bbags = getBagsThatContainBag(biggerBags.get(i), rulesMap);
                if (!bbags.isEmpty()) {
                    tempSet.addAll(bbags);
                }
            }
            if (tempSet.isEmpty()) {
                finished = true;
            } else {
                currentIndex = biggerBags.size();
                addUniqueItemsToBiggerBags(biggerBags, tempSet);
            }

        }
        return biggerBags.size();
    }

    private Map<Integer, Integer> getSmallerBagsOf(int bagId, int quantityOfBag, String rule, Map<String, Integer> itemIds, Map<Integer, Set<Integer>> rulesMap) {
        Map<Integer, Integer> smallerBags = new LinkedHashMap<>();
        if(rulesMap.get(bagId).isEmpty()) {
            return smallerBags;
        }
        String[] chunks = rule.substring(rule.indexOf("contain ") + 8, rule.indexOf('.')).split(",");
        for (String chunk : chunks) {
            String noSpace = chunk.trim();
            String bagType = noSpace.substring(noSpace.indexOf(' ') + 1, noSpace.indexOf("bag") + 3);
            int quantity = Integer.parseInt(String.valueOf(noSpace.charAt(0)));
            smallerBags.put(itemIds.get(bagType), quantity * quantityOfBag);
        }
        return smallerBags;
    }



    private void addUniqueItemsToBiggerBags(List<Integer> biggerBags, Set<Integer> tempSet) {
        for (Integer bag : tempSet) {
            if (!biggerBags.contains(bag)) {
                biggerBags.add(bag);            }
        }
    }

    private Set<Integer> getBagsThatContainBag(int bagId, Map<Integer, Set<Integer>> rulesMap) {
        Set<Integer> biggerBags = new LinkedHashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : rulesMap.entrySet()) {
            if (entry.getValue().contains(bagId)) {
                biggerBags.add(entry.getKey());
            }
        }
        return biggerBags;
    }

    private void sortBagsAndRules(String[] rules, Map<String, Integer> itemIds, Map<Integer, Set<Integer>> rulesMap) {
        boolean sorted = false;
        boolean[] sortedRules = new boolean[rules.length];
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < rules.length; i++) {
                if (!sortedRules[i]) {
                    // check if containingBags all have Ids
                    Set<Integer> contentIds = getIdsFromContent(rules[i], itemIds);
                    if (contentIds != null) {
                        Integer idOfBagType = generateNewIdForBag(rules[i], i, itemIds);
                        rulesMap.put(idOfBagType, contentIds);
                        System.out.println("Added " + idOfBagType);
                        sortedRules[i] = true;
                    }
                    sorted = false;
                }
            }
        }
    }

    private Integer generateNewIdForBag(String rule, int id,  Map<String, Integer> itemIds) {
        // if this is leaf bag, then assign one integer and add it, if not return null;
        Integer newId = id;
        String bagType = rule.substring(0, rule.indexOf(" contain") - 1);
        itemIds.putIfAbsent(bagType, newId);
        return newId;
    }

    private Set<Integer> getIdsFromContent(String rule, Map<String, Integer> itemIds) {
        if (rule.contains("contain no other bags.")) {
            return new HashSet<>();
        } else {
            Set<Integer> ids = new HashSet<>();
            Integer id;
            for (String bagTypes : extractBagTypesContentFromRule(rule)) {
                id = itemIds.get(bagTypes);
                if (id == null) {
                    return null;
                } else {
                    ids.add(id);
                }
            }
            return ids;
        }
    }

    // plaid magenta bags contain 3 faded blue bags, 5 vibrant lime bags, 2 faded beige bags.
    private Set<String> extractBagTypesContentFromRule(String rule) {
        Set<String> bagTypes = new HashSet<>();
        String[] chunks = rule.substring(rule.indexOf("contain ") + 8, rule.indexOf('.')).split(",");
        for (String chunk : chunks) {
            String noSpace = chunk.trim();
            bagTypes.add(noSpace.substring(noSpace.indexOf(' ') + 1, noSpace.indexOf("bag") + 3));
        }
        return bagTypes;
    }


}
