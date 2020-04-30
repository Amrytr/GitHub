using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BookListRazor.Model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace BookListRazor.Pages.BookList
{
    public class IndexModel : PageModel
    {

        //using for dependency injection and pipeline
        private readonly ApplicationDbContext _db;

        public IndexModel(ApplicationDbContext db)
        {
            _db = db;
        }


        public IEnumerable<Book> Books { get; set; }
        //retriving data from database of all books storing inside ienumerable and inside get handler
        public async Task OnGet()
        {
            Books = await _db.Book.ToListAsync();
        }
    }
}