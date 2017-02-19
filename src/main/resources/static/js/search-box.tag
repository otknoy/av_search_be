<search-box>
  <h4><a href="./">AV Search</a></h4>

  <form method="GET" action="./">
    <p>
      <input type="search" name="query" placeholder="Please enter a query" value="{query}" required="true" />
      <input type="submit" value="Search" />
    </p>
  </form>

  <script>
   this.query = opts.query;
  </script>

  <style>
   :scope { font-size: 2rem }
   h3 { color: #444 }
   ul { color: #999 }
  </style>
</search-box>
