using GalaSoft.MvvmLight;
using GalaSoft.MvvmLight.Messaging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WPF_MVVM.Model;

namespace WPF_MVVM.ViewModel
{
  public class DetailViewModel : ViewModelBase
    {
        public DetailViewModel()
        {
            RegisterMessage();
            Dictionary<string, string> dict = new Dictionary<string, string>();
            dict.Add("Class", "9A");
            dict.Add("Group", "8");
            dict.Add("School", "HOANG MAI");
            Student a = new Student("1", "TRAN ANH", true, dict);
        }

        private void RegisterMessage()
        {
            Messenger.Default.Register<NotificationMessage<object>>(this,(msg) => 
            {




            });
        }

       

   

    }
}
