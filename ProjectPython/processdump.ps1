$file = Get-Content -Path "processes.txt"
$array = @()

foreach($line in $file){
    $num = $line.split("-")[1]
    $array += $num
}

foreach($num in $array){
    Write-Output "Process Dumping for Process {$num}"
    .\volatility_2.6_win64_standalone.exe -f ".\memdump.raw" --profile "Win7SP1x64" procdump -D dump/ -p $num
}