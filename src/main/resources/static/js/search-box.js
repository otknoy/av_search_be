riot.tag2('search-box', '<h4><a href="./">AV Search</a></h4> <form method="GET" action="./"> <p> <input type="search" name="query" placeholder="Please enter a query" riot-value="{query}" required="true"> <input type="submit" value="Search"> </p> </form>', 'search-box,[data-is="search-box"]{ font-size: 2rem } search-box h3,[data-is="search-box"] h3{ color: #444 } search-box ul,[data-is="search-box"] ul{ color: #999 }', '', function(opts) {
   this.query = opts.query;
});
