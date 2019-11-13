using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;
using WPF_MVVM.Model;

namespace WPF_MVVM.Common
{
    public class SelectedITemsToBoolConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            string para = parameter as string;
            IList selectedItems = value as IList;
            if (para != null && selectedItems != null)
            {
                int count = selectedItems.Count;
                switch (para)
                {
                    case "EDIT":
                        if (count == 1)
                            return true;
                        else
                            return false;
                    case "ENABLE":
                        if (count >= 1)
                        {
                            if (count == 1)
                            {
                                Student temp = selectedItems[0] as Student;
                                if (temp.ShowView)
                                    return false;
                                else
                                    return true;

                            }
                            else
                                return true;
                        }
                        else
                            return false;
                    case "DISABLE":
                        if (count >= 1)
                        {
                            if (count == 1)
                            {
                                Student temp = selectedItems[0] as Student;
                                if (temp.ShowView)
                                    return true;
                                else
                                    return false;
                            }
                            else
                                return true;
                        }
                        else
                            return false;
                    case "SHOW":
                        if (count == 1)
                            return true;
                        else
                            return false;
                }
            }
            return false;
        }

        public object ConvertBack(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }

    public class BoolToOpacityConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            bool para = (bool)value ;
            if (para)
                return "1";
            else return "0.3";
        }

        public object ConvertBack(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
