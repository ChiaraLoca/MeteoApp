using MeteoAppSkeleton.Models;
using MeteoAppXF.Models;
using SQLite;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace MeteoAppXF.Controller
{
    public class DBController
    {
        private static DBController instance=null;
        private static SQLiteAsyncConnection db;
        private DBController()
        {
            var dbPAth=Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),"SQLite.db3");
            db= new SQLiteAsyncConnection(dbPAth);

            db.CreateTableAsync<PlaceDBElement>().Wait();
        }
        public static DBController get()
        {
            if (instance == null)
            {
                instance = new DBController();
            }
            return instance;
        }
        /*
       * Ritorna una lista con tutti gli items.
       */
        public Task<List<PlaceDBElement>> GetItemsAsync()
        {
            return db.Table<PlaceDBElement>().ToListAsync();
        }

        /*
         * Query con statement SQL.
         */
        public Task<List<PlaceDBElement>> GetItemsWithWhere(Guid id)
        {
            return db.QueryAsync<PlaceDBElement>("SELECT * FROM [Place] WHERE [uuid] =?", id);
        }

        /*
         * Query con LINQ.
         */
        public Task<PlaceDBElement> GetItemAsync(Guid id)
        {
            return db.Table<PlaceDBElement>().Where(i => i.uuid == id).FirstOrDefaultAsync();
        }

        /*
         * Salvataggio o update.
         */
        public Task<int> SaveItemAsync(PlaceDBElement item)
        {
            PlaceDBElement present = GetItemAsync(item.uuid).Result;
            if (present != null)
                return db.UpdateAsync(item);

            return db.InsertAsync(item);
        }

        /*
         * Cancellazione di un elemento.
         */
        public Task<int> DeleteItemAsync(Place item)
        {
            return db.DeleteAsync(item);
        }
    }

    
}
