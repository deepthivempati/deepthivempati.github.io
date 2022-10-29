---
title:  "Markdown Reference"
date:   2022-10-09 10:54:00
# layout: posts
categories: ['Miscellaneous']
tags: ['Miscellaneous']
toc: true
[//]: # (classes: wide)
---


## Add right side Index bar on this blog

{% raw  %}
`{% include toc title="Index" %}`
{% endraw %}

Or simpley add `toc: true` on the [front matter](https://jekyllrb.com/docs/front-matter/)


## Include gists as

Include code as a gist into the Jekyll post. Uses jekyll-gist plugin.
{% raw  %}
`{% gist nitinkc/8a3eb81f7ccf93b013a2fe8455a04703 %}`
{% endraw %}

## INCLUDE TIME

| Column Header 1 | Column Header 1  | 
| :---				| :---   |  
|Site Build Time to be displayed{% raw  %}`{{ site.time  }}`{% endraw %} |{{ site.time  }}|
|{% raw  %}`{{ 'now' | date: "%Y/%m/%d" }}`{% endraw %}|{{ 'now' | date: "%Y/%m/%d" }}|
|{% raw  %}`{{ 'now' | date_to_rfc822 }}`{% endraw %}|{{ 'now' | date_to_rfc822 }}|
|{% raw  %}`{{ 'now' | date: "%C" }}`{% endraw %}|{{ 'now' | date: "%C" }}|
|{% raw  %}`{{ 'now' | date: "%c" }}`{% endraw %}|{{ 'now' | date: "%c" }}|
|{% raw  %}`{{ 'now' | date: "%a, %b %-d %Y - %r %Z" }}`{% endraw %}|{{ 'now' | date: "%a, %b %-d %Y - %r %Z" }}|

## Markdown links syntax

If you're building your pages with markdown, use the following examples to generate internal links.


```markdown
{% raw  %}
[Link title]({{ site.baseurl }}{% link index.html %})

[Link title]({% post_url 2016-04-04-jekyll-blog-GitHub-hosting %})

[Link title]({{ site.baseurl }}{% post_url 2016-04-04-jekyll-blog-GitHub-hosting %})
{% endraw %}
```

## Use a picture in a post from specific folder
{% raw  %}
`![Image Text]({{ site.url }}/assets/images/image.png)`
{% endraw %}

## Escape Liquid template tags in Jekyll posts

* Use raw tag
  * to begin `{{ "{% raw " }}%}` and end with `{{ "{% endraw " }}%} `
* Another way to escape `{{ "{{ tag " }}}}`

Use backtick quotes (\`) to display a liquid tag as a span of code .

## Insert Table

```markdown
| Column Header 1 | Column Header 1  | 
| :---		| :---   |      
| ⌘E    	| Move to the last location you edited.	|
| ⌘  + 1  	|It activates the quick fix.|
```

## Add Sidebar Navigation

In the header tag add

```markdown
---
sidebar:
  nav: "algo"
---
```

## Notices with theme

Notice [emphasized](#notices-with-theme) with the `{: .notice}` class.
{: .notice}

Notice [emphasized](#notices-with-theme) with the `{: .notice--primary}` class.
{: .notice--primary}

Notice [emphasized](#notices-with-theme) with the `{: .notice--info}` class.
{: .notice--info}

Notice [emphasized](#notices-with-theme) with the `{: .notice--warning}` class.
{: .notice--warning}

Notice [emphasized](#notices-with-theme) with the `{: .notice--success}` class.
{: .notice--success}

Notice [emphasized](#notices-with-theme) with the `{: .notice--danger}` class.
{: .notice--danger}

## Enable collapsible code block individually on page

* 1) Add after the front matter on individual page
* `{::options parse_block_html="true" /}`
* 2) Add below tags when collapsible code block needs to be enabled

```
<details>
<summary markdown ="span">text</summary>
</details>
```

## Enable collapsible code block by default

* 1) Add these lines in _config.yml

```
markdown: kramdown
  kramdown: 
    parse_block_html: true
    parse_span_html: true
```
* 2) Add below tags when collapsible code block needs to be enabled

```
<details>
<summary>text</summary>
</details>

```

 


