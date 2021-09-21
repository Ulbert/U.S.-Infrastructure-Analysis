import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.backends.backend_pdf
pdf = matplotlib.backends.backend_pdf.PdfPages("output.pdf")

plt.rcParams['figure.figsize'] = [20, 10]

original_data = pd.read_csv("analyze.csv")
normalized_data = pd.read_csv('analyze_normalized.csv')


def reg_line(title,d,x,y):#simple regression line for graph

    plt.plot(d[x],d[y], 'o')
    m,b = np.polyfit(d[x],d[y],1)
    plt.plot(d[x], m*d[x] + b)
    plt.xlabel(x)
    plt.ylabel(y)
    plt.title(title)
    plt.savefig(title)

og = original_data.set_index(["state", "county"])
og= og.apply(pd.to_numeric)
# og= og[(og['state_local_income_tax'] < 50000) & (og['state_local_income_tax'] > 0)]
ogsamp = og.sample(n=100)
reg_line("Ratio Fair to Poor Bridges vs. State and Local Income Tax",ogsamp,'state_local_income_tax','ratio_fair_to_poor')


reg_line("Bridges Normalized vs. State and Local Income Tax Normalized", t, 'state_local_income_tax_normalized', 'bridges_normalized')
x = normalized_data.set_index(["state", "county"])
x= x.apply(pd.to_numeric)
t = x.sample(n=100)

reg_line("Number of Water Systems Normalized vs. State and Local Income Tax Normalized",t, 'state_local_income_tax_normalized', 'water_systems_normalized')

reg_line("Freight Per Sq Mile Normalized vs. State and Local Income Tax Normalized",t[t['freight_per_sq_mile_normalized']<8], 'state_local_income_tax_normalized', 'freight_per_sq_mile_normalized')


reg_line("Number of Roads Acceptable vs. State and Local Income Tax Normalized",t, 'state_local_income_tax_normalized', 'roads_acceptable_normalized')

# reg_line(t, 'state_local_income_tax_normalized', 'water_sys_per_cap_normalized')
reg_line("Number of Water Systems per Capita Normalized vs. Populartion Served Normalized",t[t['water_sys_per_cap_normalized']<3], 'population_served_normalized','water_sys_per_cap_normalized')


reg_line("Ratio of Fair to Poor Bridges Normalized vs. Real Estate Tax Normalized",t,'real_estate_tax_normalized','ratio_fair_to_poor_normalized')


reg_line("Number of Water Sytems Normalized vs. Estate Tax per Sq Mi Normalized",t[t['water_systems_normalized']<3],'estate_tax_per_sq_normalized','water_systems_normalized')


reg_line("Number of Water Systems per Capita Normalized vs. Estate Tax per Sq Mi Normalized",t[(t['estate_tax_per_sq_normalized']<.2)&(t['water_sys_per_cap_normalized']<3)],'estate_tax_per_sq_normalized','water_sys_per_cap_normalized')


reg_line("Number of Roads Acceptable Normalized vs. Estate Tax per Sq Mi Normalized",t,'estate_tax_per_sq_normalized','roads_acceptable_normalized')



x = normalized_data.set_index(["state", "county"])
x= x.apply(pd.to_numeric)
#take out the outliers
x= x[(x['state_local_income_tax_normalized'] < 0.4) & (x['state_local_income_tax_normalized'] > 0)]

x= x[(x['real_estate_tax_normalized'] < 0.4) & (x['real_estate_tax_normalized'] > 0)]
t = x.sample(n=100)

reg_line("Bridges Normalized vs. State and Local Income Tax Normalized", t, 'state_local_income_tax_normalized', 'bridges_normalized')


reg_line("Number of Water Systems Normalized vs. State and Local Income Tax Normalized",t, 'state_local_income_tax_normalized', 'water_systems_normalized')

reg_line("Freight Per Sq Mile Normalized vs. State and Local Income Tax Normalized",t[t['freight_per_sq_mile_normalized']<8], 'state_local_income_tax_normalized', 'freight_per_sq_mile_normalized')


reg_line("Number of Roads Acceptable vs. State and Local Income Tax Normalized",t, 'state_local_income_tax_normalized', 'roads_acceptable_normalized')

# reg_line(t, 'state_local_income_tax_normalized', 'water_sys_per_cap_normalized')
reg_line("Number of Water Systems per Capita Normalized vs. Populartion Served Normalized",t[t['water_sys_per_cap_normalized']<3], 'population_served_normalized','water_sys_per_cap_normalized')


reg_line("Ratio of Fair to Poor Bridges Normalized vs. Real Estate Tax Normalized",t,'real_estate_tax_normalized','ratio_fair_to_poor_normalized')


reg_line("Number of Water Sytems Normalized vs. Estate Tax per Sq Mi Normalized",t[t['water_systems_normalized']<3],'estate_tax_per_sq_normalized','water_systems_normalized')


reg_line("Number of Water Systems per Capita Normalized vs. Estate Tax per Sq Mi Normalized",t[(t['estate_tax_per_sq_normalized']<.2)&(t['water_sys_per_cap_normalized']<3)],'estate_tax_per_sq_normalized','water_sys_per_cap_normalized')


reg_line("Number of Roads Acceptable Normalized vs. Estate Tax per Sq Mi Normalized",t,'estate_tax_per_sq_normalized','roads_acceptable_normalized')

# reg_line(t[(t['population_density_normalized']<4)&(t['estate_tax_per_sq_normalized']<0.2)],'population_density_normalized','estate_tax_per_sq_normalized')



